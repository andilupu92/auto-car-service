package auto.trace.mapper;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
import auto.trace.entity.Car;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "healthScore", expression = "java(calculateHealthScore(car.getFinancialHealth(), car.getMechanicalHealth()))")
    CarResponse toResponse(Car car);

    @InheritConfiguration(name = "toResponse")
    List<CarResponse> toResponseList(List<Car> cars);

    Car toEntity(CarRequest carRequest);

    default Integer calculateHealthScore(Integer financialHealth, Integer mechanicalHealth) {
        if (financialHealth == null && mechanicalHealth == null) {
            return null;
        }

        return (financialHealth + mechanicalHealth) / 2;
    }
}
