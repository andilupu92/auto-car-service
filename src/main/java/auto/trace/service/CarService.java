package auto.trace.service;

import auto.trace.dto.CarDto;
import auto.trace.entity.Car;
import auto.trace.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Long userId, CarDto carDto) {

        Car c = Car.builder()
                .userId(userId)
                .brand(carDto.brand())
                .model(carDto.model())
                .year(carDto.year())
                .kilometers(carDto.kilometers())
                .build();

        return carRepository.save(c);
    }
}
