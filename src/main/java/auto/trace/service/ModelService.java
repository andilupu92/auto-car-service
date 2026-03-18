package auto.trace.service;

import auto.trace.dto.ModelDto;
import auto.trace.mapper.ModelMapper;
import auto.trace.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public ModelService(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    public List<ModelDto> getModelsFromBrand(Long brandId) {
        return modelMapper.toResponseList(modelRepository.findByBrandId(brandId));
    }
}
