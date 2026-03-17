package auto.trace.controller;

import auto.trace.dto.BrandDto;
import auto.trace.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<BrandDto>> getBrands() {
        return new ResponseEntity<>(brandService.getBrands(), HttpStatus.OK);
    }
}
