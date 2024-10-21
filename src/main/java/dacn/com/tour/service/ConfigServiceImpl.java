package dacn.com.tour.service;

import dacn.com.tour.dto.request.ConfigCreateRequest;
import dacn.com.tour.dto.request.ConfigUpdateRequest;
import dacn.com.tour.dto.response.ConfigResponse;
import dacn.com.tour.mapper.ConfigMapper;
import dacn.com.tour.model.Config;
import dacn.com.tour.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfigServiceImpl implements ConfigService {
    private final ConfigMapper configMapper;
    private final ConfigRepository configRepository;


    @Override
    public List<ConfigResponse> listAll() {
        List<Config> configList = configRepository.findAll();

        return configList.stream().map(configMapper::configToConfigResponse).toList();
    }

    @Override
    public List<ConfigResponse> listConfigSearchByInfoType(String infoType) {
        List<Config> configList = configRepository.findConfigByInfoTypeIsLikeIgnoreCase("%" + infoType + "%");

        return configList.stream().map(configMapper::configToConfigResponse).toList();
    }

    @Override
    public ConfigResponse read(Long id) {
        return configMapper.configToConfigResponse(configRepository.findById(id).orElseThrow());
    }

    @Override
    public ConfigResponse create(ConfigCreateRequest request) {


        return null;
    }

    @Override
    public ConfigResponse update(Long id, ConfigUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
