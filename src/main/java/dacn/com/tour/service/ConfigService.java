package dacn.com.tour.service;

import dacn.com.tour.dto.request.ConfigCreateRequest;
import dacn.com.tour.dto.request.ConfigUpdateRequest;
import dacn.com.tour.dto.response.ConfigResponse;

import java.util.List;

public interface ConfigService {
    List<ConfigResponse> listAll();
    List<ConfigResponse> listConfigSearchByInfoType(String infoType);
    ConfigResponse read(Long id);
    ConfigResponse create(ConfigCreateRequest request);
    ConfigResponse update(Long id, ConfigUpdateRequest request);
    void delete(Long id);
}
