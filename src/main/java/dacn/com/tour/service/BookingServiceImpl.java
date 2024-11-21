package dacn.com.tour.service;

import dacn.com.tour.dto.request.BookingCreateRequest;
import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.exception.AppException;
import dacn.com.tour.exception.ErrorCode;
import dacn.com.tour.mapper.BookingMapper;
import dacn.com.tour.model.Account;
import dacn.com.tour.model.Booking;
import dacn.com.tour.model.Tour;
import dacn.com.tour.repository.AccountRepository;
import dacn.com.tour.repository.BookingRepository;
import dacn.com.tour.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final TourRepository tourRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<BookingResponse> listAll() {
        return bookingRepository.findAll().stream().map(bookingMapper::bookingToBookingResponse).toList();
    }

    @Override
    public BookingResponse getById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(RuntimeException::new);

        return bookingMapper.bookingToBookingResponse(booking);
    }

    @Override
    public BookingResponse create(Long tourId, Long userId,  BookingCreateRequest request) {
        // Kiểm tra xem tour có tồn tại không
        Tour tour = tourRepository.findById(tourId).orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_FOUND));

        // Kiểm tra xem tài khoản có tồn tại không
        Account account = accountRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        // Chuyển đổi từ request thành đối tượng Booking
        Booking booking = bookingMapper.bookingCreateRequestToBooking(request);

        booking.setAccount(account);
        booking.setTour(tour);

        tour.getBookings().add(booking);

        tourRepository.save(tour);


        return bookingMapper.bookingToBookingResponse(booking);
    }

    @Override
    public BookingResponse update(Long id, UserUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
