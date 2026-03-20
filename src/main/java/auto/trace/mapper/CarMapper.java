package auto.trace.mapper;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
import auto.trace.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car toEntity(CarRequest carRequest);
    List<CarResponse> toResponseList(List<Car> cars);
    CarResponse toResponse(Car car);
    void updateEntityFromRequest(CarRequest request, @MappingTarget Car car);
}
