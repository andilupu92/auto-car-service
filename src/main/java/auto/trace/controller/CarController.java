package auto.trace.controller;

import auto.trace.dto.CarDto;
import auto.trace.entity.Car;
import auto.trace.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCarsFromUser(@RequestHeader("X-User-Id") Long userId) {
        return new ResponseEntity<>(carService.getCarsFromUser(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> add(@RequestHeader("X-User-Id") Long userId,
                                   @Valid @RequestBody CarDto carDto) {

        return new ResponseEntity<>(carService.addCar(userId, carDto), HttpStatus.CREATED);
    }
}
