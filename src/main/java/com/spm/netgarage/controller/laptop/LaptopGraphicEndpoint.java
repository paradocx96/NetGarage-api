package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.api.laptop.LaptopGraphicApi;
import com.spm.netgarage.domain.laptop.LaptopGraphic;
import com.spm.netgarage.dto.laptop.LaptopGraphicDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop-graphic")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopGraphicEndpoint {

    private final LaptopGraphicApi laptopGraphicApi;

    @Autowired
    public LaptopGraphicEndpoint(LaptopGraphicApi laptopGraphicApi) {
        this.laptopGraphicApi = laptopGraphicApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LaptopGraphic addLaptopGraphic(@RequestBody LaptopGraphicDto laptopGraphicDto) {
        return null;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopGraphic> getAllLaptopGraphic() {
        return null;
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopGraphic> getLaptopGraphicById(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopGraphicById(@PathVariable String id) {
        return null;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LaptopGraphic updateLaptopGraphic(@RequestBody LaptopGraphicDto laptopGraphicDto, @PathVariable String id) {
        return null;
    }
}
