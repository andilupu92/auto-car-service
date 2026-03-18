package auto.trace.service;

import auto.trace.dto.CarDto;
import auto.trace.entity.Car;
import auto.trace.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarsFromUser(Long userId) {
        return carRepository.findByUserId(userId);
    }

    public Car addCar(Long userId, CarDto carDto) {

        Car c = Car.builder()
                .userId(userId)
                .brandId(carDto.brandId())
                .modelId(carDto.modelId())
                .year(carDto.year())
                .kilometers(carDto.kilometers())
                .build();

        return carRepository.save(c);
    }
}
