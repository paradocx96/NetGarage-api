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
        LaptopGraphic laptopGraphic = new LaptopGraphic();

        laptopGraphic.setName(laptopGraphicDto.getName());
        laptopGraphic.setUser(laptopGraphicDto.getUser());

        return laptopGraphicApi.saveLaptopGraphic(laptopGraphic);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopGraphic> getAllLaptopGraphic() {
        return laptopGraphicApi.getAllLaptopGraphic();
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopGraphic> getLaptopGraphicById(@PathVariable String id) {
        return laptopGraphicApi.getLaptopGraphicById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopGraphicById(@PathVariable String id) {
        return laptopGraphicApi.deleteLaptopGraphicById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public LaptopGraphic updateLaptopGraphic(@RequestBody LaptopGraphicDto laptopGraphicDto) {
        LaptopGraphic laptopGraphic = new LaptopGraphic();

        laptopGraphic.setId(laptopGraphicDto.getId());
        laptopGraphic.setName(laptopGraphicDto.getName());
        laptopGraphic.setUser(laptopGraphicDto.getUser());

        return laptopGraphicApi.updateLaptopGraphic(laptopGraphic);
    }
}