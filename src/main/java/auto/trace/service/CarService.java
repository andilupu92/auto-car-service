package auto.trace.service;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
import auto.trace.entity.Car;
import auto.trace.mapper.CarMapper;
import auto.trace.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<CarResponse> getCarsFromUser(Long userId) {
        return carMapper.toResponseList(carRepository.findByUserId(userId));
    }

    public CarResponse addCar(Long userId, CarRequest carRequest) {

        Car c = carMapper.toEntity(carRequest);
        c.setUserId(userId);

        return carMapper.toResponse(carRepository.save(c));
    }
}
