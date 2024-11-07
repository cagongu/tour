package dacn.com.tour.controller;

import dacn.com.tour.dto.request.BookingCreateRequest;
import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookingController {
    private static final String BOOKING_PATH = "/booking";
    private static final String BOOKING_PATH_ID = BOOKING_PATH + "/{idOrder}";

    private final BookingService bookingService;

    @PostMapping(BOOKING_PATH)
    public ApiResponse<BookingResponse> createBooking(@RequestParam Long userId,
                                                      @RequestParam Long tourId,
                                                      @RequestBody BookingCreateRequest request){
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.create(tourId, userId, request))
                .build();
    }

}
