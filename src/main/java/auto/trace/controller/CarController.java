package auto.trace.controller;

import auto.trace.dto.CarDto;
import auto.trace.entity.Car;
import auto.trace.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarService carService;

    CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/add")
    public ResponseEntity<Car> add(@RequestHeader("X-User-Id") Long userId,
                                   @RequestBody CarDto carDto) {

        return new ResponseEntity<>(carService.addCar(userId, carDto), HttpStatus.CREATED);
    }
}
