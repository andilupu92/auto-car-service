package auto.trace.service;

import auto.trace.dto.response.BrandResponse;
import auto.trace.mapper.BrandMapper;
import auto.trace.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    public List<BrandResponse> getBrands() {
        return brandMapper.toResponseList(brandRepository.findAll());
    }
}
