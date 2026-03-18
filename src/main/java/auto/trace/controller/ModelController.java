package auto.trace.controller;

import auto.trace.dto.ModelDto;
import auto.trace.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<List<ModelDto>> getModelsFromBrand(@PathVariable Long brandId) {
        return new ResponseEntity<>(modelService.getModelsFromBrand(brandId), HttpStatus.OK);
    }
}
