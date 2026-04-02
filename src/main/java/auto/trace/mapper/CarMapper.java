package auto.trace.mapper;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
import auto.trace.entity.Car;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "brand.logoUrl", target = "logoUrl")
    @Mapping(source = "model.id", target = "modelId")
    @Mapping(source = "model.name", target = "modelName")
    CarResponse toResponse(Car car);

    @InheritConfiguration(name = "toResponse")
    List<CarResponse> toResponseList(List<Car> cars);

    Car toEntity(CarRequest carRequest);
    void updateEntityFromRequest(CarRequest request, @MappingTarget Car car);
}
