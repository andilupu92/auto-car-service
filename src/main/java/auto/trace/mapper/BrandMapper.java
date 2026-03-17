package auto.trace.mapper;

import auto.trace.dto.BrandDto;
import auto.trace.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    List<BrandDto> toResponseList(List<Brand> brands);
}
