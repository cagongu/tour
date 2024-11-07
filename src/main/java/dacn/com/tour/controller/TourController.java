package dacn.com.tour.controller;

import dacn.com.tour.dto.request.TourCreationRequest;
import dacn.com.tour.dto.request.TourUpdateRequest;
import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.TourResponse;
import dacn.com.tour.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TourController {
    private static final String TOUR_PATH = "/tour";
    private static final String TOUR_PATH_ID = TOUR_PATH + "/{idTour}";
    private final TourService tourService;

    @GetMapping(TOUR_PATH)
    public ApiResponse<List<TourResponse>> getAll(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String place

    ) {

        return ApiResponse.<List<TourResponse>>builder()
                .result(tourService.listAll(description, type, place))
                .build();

    }

    @GetMapping(TOUR_PATH_ID)
    public ApiResponse<TourResponse> getById(@PathVariable("idTour") Long idTour) {
        return ApiResponse.<TourResponse>builder()
                .result(tourService.getById(idTour))
                .build();
    }

    @PostMapping(TOUR_PATH)
    public ApiResponse<TourResponse> createNewTour(@RequestBody TourCreationRequest request) {
        return ApiResponse.<TourResponse>builder()
                .result(tourService.create(request))
                .build();
    }

    @PutMapping(TOUR_PATH_ID)
    public ApiResponse<TourResponse> updateTour(@PathVariable("idTour") Long idTour, @RequestBody TourUpdateRequest request) {
        return ApiResponse.<TourResponse>builder()
                .result(tourService.update(idTour, request))
                .build();
    }

    @PutMapping(TOUR_PATH + "/add-favorite/{idTour}")
    public ApiResponse<TourResponse> addFavorite(@PathVariable("idTour") Long idTour,
                                                 @RequestParam("userId") Long userId) {
        return ApiResponse.<TourResponse>builder()
                .result(tourService.addFavorite(userId, idTour))
                .build();
    }

    @PutMapping(TOUR_PATH + "/remove-favorite/{idTour}")
    public ApiResponse<TourResponse> removeFavorite(@PathVariable("idTour") Long idTour,
                                                    @RequestParam("userId") Long userId) {
        return ApiResponse.<TourResponse>builder()
                .result(tourService.removeFavorite(userId, idTour))
                .build();
    }
}
