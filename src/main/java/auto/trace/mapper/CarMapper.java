package auto.trace.mapper;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
import auto.trace.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car toEntity(CarRequest carRequest);
    List<CarResponse> toResponseList(List<Car> cars);
    CarResponse toResponse(Car car);
}
