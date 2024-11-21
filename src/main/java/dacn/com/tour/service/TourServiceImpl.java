package dacn.com.tour.service;

import dacn.com.tour.dto.request.TourCreationRequest;
import dacn.com.tour.dto.request.TourUpdateRequest;
import dacn.com.tour.dto.response.TourResponse;
import dacn.com.tour.enums.StatusAction;
import dacn.com.tour.exception.AppException;
import dacn.com.tour.exception.ErrorCode;
import dacn.com.tour.mapper.TourMapper;
import dacn.com.tour.model.Account;
import dacn.com.tour.model.Favorite;
import dacn.com.tour.model.Tour;
import dacn.com.tour.repository.AccountRepository;
import dacn.com.tour.repository.BookingRepository;
import dacn.com.tour.repository.FavoriteRepository;
import dacn.com.tour.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourMapper tourMapper;
    private final FavoriteRepository favoriteRepository;
    private final AccountRepository accountRepository;
    private final BookingRepository bookingRepository;

    @Override
    public List<TourResponse> listAll(String description, String type, String place) {
        log.info("Fetching all tours");

        if(StringUtils.hasText(description))
            return listAllByDescription(description);
        else if(StringUtils.hasText(type))
            return listAllByType(type);
        else if(StringUtils.hasText(place))
            return listAllByPlace(place);
        else {
            List<Tour> tours = tourRepository.findAll();
            return tours.stream()
                    .map(tourMapper::tourToTourResponse)
                     .filter(tour -> tour.getStatus() != StatusAction.DELETE)
                    .toList();
        }
    }

    public List<TourResponse> listAllByDescription(String name)  {
        List<Tour> tours = tourRepository.findAllByDescriptionIsLikeIgnoreCase("%" + name + "%");

        return tours.stream()
                .map(tourMapper::tourToTourResponse)
                 .filter(tour -> tour.getStatus() != StatusAction.DELETE)
                .toList();
    }

    public List<TourResponse> listAllByType(String name) {
        List<Tour> tours = tourRepository.findAllByTypeIsLikeIgnoreCase("%" + name + "%");

        return tours.stream()
                .map(tourMapper::tourToTourResponse)
                 .filter(tour -> tour.getStatus() != StatusAction.DELETE)
                .toList();
    }

    public List<TourResponse> listAllByPlace(String name) {
        List<Tour> tours = tourRepository.findAllByAddressIsLikeIgnoreCase("%" + name + "%");

        return tours.stream()
                .map(tourMapper::tourToTourResponse)
                 .filter(tour -> tour.getStatus() != StatusAction.DELETE)
                .toList();
    }

    @Override
    public TourResponse getById(Long id) {
        log.info("Fetching tour with ID: {}", id);
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));
        return tourMapper.tourToTourResponse(tour);
    }

    @Override
    @Transactional
    public TourResponse create(TourCreationRequest request) {
        log.info("Creating new tour");
        Tour tour = tourMapper.tourCreateRequestToTour(request);
        return tourMapper.tourToTourResponse(tourRepository.save(tour));
    }

    @Override
    @Transactional
    public TourResponse update(Long id, TourUpdateRequest request) {
        log.info("Updating tour with ID: {}", id);
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));

        tourMapper.updateTour(tour, request);
        return tourMapper.tourToTourResponse(tourRepository.save(tour));
    }

    @Override
    public TourResponse addFavorite(Long userId, Long tourId) {
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));

        Account account = accountRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        Favorite favorite = Favorite.builder()
                .account(account)
                .statusAction(StatusAction.ACTIVE.name())
                .build();

        tour.getFavorites().add(favorite);

        tourRepository.save(tour);

        return tourMapper.tourToTourResponse(tour);
    }

    @Override
    public TourResponse removeFavorite(Long userId, Long tourId) {
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));


        tour.getFavorites().forEach(favorite -> {
            if(favorite.getAccount().getIdAccount().equals(userId)){
                favorite.setStatusAction(StatusAction.DELETE.name());
            }
        });

        tourRepository.save(tour);

        return tourMapper.tourToTourResponse(tour);
    }


    @Override
    @Transactional
    public TourResponse delete(Long id) {
        log.info("Deleting tour with ID: {}", id);
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));

        tour.setStatus(StatusAction.DELETE);

        return  tourMapper.tourToTourResponse(tourRepository.save(tour));
//        tourRepository.deleteById(tour.getIdTour());
    }
}
