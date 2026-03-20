package auto.trace.service;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
import auto.trace.entity.Car;
import auto.trace.mapper.CarMapper;
import auto.trace.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public CarResponse save(Long userId, CarRequest carRequest, Long id) {
        Car c;

        if (id != null) {
            c = carRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Car not found: " + id));
            carMapper.updateEntityFromRequest(carRequest, c);
        } else {
            c = carMapper.toEntity(carRequest);
        }

        c.setUserId(userId);
        return carMapper.toResponse(carRepository.save(c));
    }

}
