package auto.trace.mapper;

import auto.trace.dto.response.BrandResponse;
import auto.trace.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    List<BrandResponse> toResponseList(List<Brand> brands);
}
