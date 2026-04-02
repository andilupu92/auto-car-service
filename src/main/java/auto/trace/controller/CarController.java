package auto.trace.controller;

import auto.trace.dto.request.CarRequest;
import auto.trace.dto.response.CarResponse;
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
    public ResponseEntity<List<CarResponse>> getCarsFromUser(@RequestHeader("X-User-Id") Long userId) {
        return new ResponseEntity<>(carService.getCarsFromUser(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarResponse> add(@RequestHeader("X-User-Id") Long userId,
                                           @Valid @RequestBody CarRequest carRequest) {

        return new ResponseEntity<>(carService.save(userId, carRequest, null), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponse> update(@RequestHeader("X-User-Id") Long userId,
                                              @Valid @RequestBody CarRequest carRequest,
                                              @PathVariable Long id) {

        return new ResponseEntity<>(carService.save(userId, carRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
