package dacn.com.tour.service;

import dacn.com.tour.dto.request.BookingCreateRequest;
import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.mapper.BookingMapper;
import dacn.com.tour.model.Booking;
import dacn.com.tour.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

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
    public BookingResponse create(BookingCreateRequest request) {
        Booking booking = bookingMapper.bookingCreateRequestToBooking(request);

        return bookingMapper.bookingToBookingResponse(bookingRepository.save(booking));

    }

    @Override
    public BookingResponse update(Long id, UserUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
