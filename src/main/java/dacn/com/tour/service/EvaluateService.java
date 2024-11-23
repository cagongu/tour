package dacn.com.tour.service;

import dacn.com.tour.dto.request.EvaluateRequest;
import dacn.com.tour.dto.response.EvaluateResponse;

import java.util.List;

public interface EvaluateService {
    EvaluateResponse createEvaluate(EvaluateRequest request);

    List<EvaluateResponse> getAllEvaluate();
}
