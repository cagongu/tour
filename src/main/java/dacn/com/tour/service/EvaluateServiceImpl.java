package dacn.com.tour.service;

import dacn.com.tour.dto.request.EvaluateRequest;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.dto.response.EvaluateResponse;
import dacn.com.tour.mapper.BookingMapper;
import dacn.com.tour.mapper.EvaluateMapper;
import dacn.com.tour.model.Booking;
import dacn.com.tour.model.Evaluate;
import dacn.com.tour.repository.AccountRepository;
import dacn.com.tour.repository.EvaluateRepository;
import dacn.com.tour.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluateServiceImpl implements EvaluateService {
    private final EvaluateRepository evaluateRepository;
    private final BookingRepository bookingRepository;
    private final AccountRepository accountRepository;
    private final EvaluateMapper mapper;
    private final BookingMapper bookingMapper;

    @Override
    public EvaluateResponse createEvaluate(EvaluateRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingId()).orElseThrow();

        Evaluate evaluate = Evaluate.builder()
                .account(accountRepository.findById(request.getAccountId()).orElse(null))
                .booking(booking)
                .content(request.getContent())
                .title(request.getTitle())
                .numberStar(request.getNumberStar())
                .build();

        evaluateRepository.save(evaluate);

        booking.setEvaluate(evaluate);
        bookingRepository.save(booking);

        return mapper.evaluateToResponse(evaluate);
    }

    @Override
    public List<EvaluateResponse> getAllEvaluate() {
        return evaluateRepository.findAll().stream().map(mapper::evaluateToResponse).toList();
    }

    @Override
    public List<EvaluateResponse> getAllByTourId(Long tourId) {
        List<BookingResponse> bookingResponseList = bookingRepository.findAll().stream()
                .filter(booking -> booking.getTour().getIdTour().equals(tourId))
                .map(bookingMapper::bookingToBookingResponse)
                .toList();

        List<EvaluateResponse> evaluateResponseList = new ArrayList<>();

        for(var booking : bookingResponseList){
            evaluateResponseList.add(mapper.evaluateToResponse(booking.getEvaluate()));
        }

        return evaluateResponseList;
    }
}
