package dacn.com.tour.service;

import dacn.com.tour.dto.request.BookingCreateRequest;

import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.BookingResponse;


import java.util.List;

public interface BookingService {
    List<BookingResponse> listAll();

    BookingResponse getById(Long id);
    BookingResponse create(Long tourId, Long userId, BookingCreateRequest request);
    BookingResponse update(Long id, UserUpdateRequest request);
    void delete(Long id);
}
