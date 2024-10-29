package dacn.com.tour.controller;

import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.TourResponse;

import dacn.com.tour.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TourController {
    private static final String TOUR_PATH = "/tour";
    private static final String TOUR_PATH_ID = TOUR_PATH + "/{idTour}";
    private final TourService tourService;

    @GetMapping(TOUR_PATH)
    public ApiResponse<List<TourResponse>> getAll(@RequestParam(required = false) String description){
        if(!StringUtils.hasText(description)){
            return ApiResponse.<List<TourResponse>>builder()
                    .result(tourService.listAll())
                    .build();
        }else{
            return ApiResponse.<List<TourResponse>>builder()
                    .result(tourService.listAllByDescription(description)).build();
        }
    }

}
