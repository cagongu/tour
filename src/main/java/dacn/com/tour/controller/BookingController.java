package dacn.com.tour.controller;

import dacn.com.tour.dto.request.BookingCreateRequest;
import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ApiResponse<BookingResponse> createBooking(@RequestBody BookingCreateRequest request){
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.create(request))
                .build();
    }

}
