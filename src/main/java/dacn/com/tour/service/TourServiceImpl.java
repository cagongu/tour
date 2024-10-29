package dacn.com.tour.service;

import dacn.com.tour.dto.request.TourCreationRequest;
import dacn.com.tour.dto.request.TourUpdateRequest;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.dto.response.TourResponse;
import dacn.com.tour.exception.AppException;
import dacn.com.tour.exception.ErrorCode;
import dacn.com.tour.mapper.TourMapper;
import dacn.com.tour.model.Tour;
import dacn.com.tour.repository.BookingRepository;
import dacn.com.tour.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourMapper tourMapper;
    private final BookingRepository bookingRepository;

    @Override
    public List<TourResponse> listAll() {
        log.info("Fetching all tours");
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .map(tourMapper::tourToTourResponse)
                .toList();
    }

    @Override
    public List<TourResponse> listAllByDescription(String name)  {
        List<Tour> tours = tourRepository.findAllByDescriptionIsLikeIgnoreCase("%" + name + "%");

        return tours.stream()
                .map(tourMapper::tourToTourResponse)
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
    @Transactional
    public void delete(Long id) {
        log.info("Deleting tour with ID: {}", id);
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));
        tourRepository.deleteById(tour.getIdTour());
    }
}
