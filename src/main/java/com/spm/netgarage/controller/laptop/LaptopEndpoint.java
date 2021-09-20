package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.api.laptop.LaptopApi;
import com.spm.netgarage.dal.model.laptop.LaptopModel;
import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.dto.laptop.LaptopDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopEndpoint {

    private final LaptopApi laptopApi;

    @Autowired
    public LaptopEndpoint(LaptopApi laptopApi) {
        this.laptopApi = laptopApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop addLaptop(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = new Laptop();

        laptop.setUser(laptopDto.getUser());
        laptop.setStatus(laptopDto.getStatus());
        laptop.setName(laptopDto.getName());
        laptop.setType(laptopDto.getType());
        laptop.setYear(laptopDto.getYear());
        laptop.setBrand(laptopDto.getBrand());
        laptop.setOs(laptopDto.getOs());
        laptop.setModel(laptopDto.getModel());
        laptop.setProcessorname(laptopDto.getProcessorname());
        laptop.setProcessordetails(laptopDto.getProcessordetails());
        laptop.setProcessorgeneration(laptopDto.getProcessorgeneration());
        laptop.setChipset(laptopDto.getChipset());
        laptop.setRamtype(laptopDto.getRamtype());
        laptop.setRamcapacity(laptopDto.getRamcapacity());
        laptop.setRamslotstype(laptopDto.getRamslotstype());
        laptop.setRamslotscount(laptopDto.getRamslotscount());
        laptop.setStoragefirst(laptopDto.getStoragefirst());
        laptop.setStoragefirstcapacity(laptopDto.getStoragefirstcapacity());
        laptop.setStoragesecond(laptopDto.getStoragesecond());
        laptop.setStoragesecondcapacity(laptopDto.getStoragesecondcapacity());
        laptop.setDisplaysizeresolution(laptopDto.getDisplaysizeresolution());
        laptop.setDisplayrefreshrate(laptopDto.getDisplayrefreshrate());
        laptop.setDisplaytype(laptopDto.getDisplaytype());
        laptop.setGraphicbrand(laptopDto.getGraphicbrand());
        laptop.setGraphicmodel(laptopDto.getGraphicmodel());
        laptop.setGraphiccapacity(laptopDto.getGraphiccapacity());
        laptop.setGraphicdetails(laptopDto.getGraphicdetails());
        laptop.setWebcam(laptopDto.getWebcam());
        laptop.setKeyboard(laptopDto.getKeyboard());
        laptop.setCommunication(laptopDto.getCommunication());
        laptop.setAudio(laptopDto.getAudio());
        laptop.setIoports(laptopDto.getIoports());
        laptop.setBattery(laptopDto.getBattery());
        laptop.setDimension(laptopDto.getDimension());
        laptop.setWeight(laptopDto.getWeight());
        laptop.setColor(laptopDto.getColor());

        return laptopApi.saveLaptop(laptop);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getAllLaptop() {
        return laptopApi.getAllLaptop();
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopById(@PathVariable String id) {
        return laptopApi.getLaptopById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopById(@PathVariable String id) {
        return laptopApi.deleteLaptopById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptop(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = new Laptop();

        laptop.setId(laptopDto.getId());
        laptop.setUser(laptopDto.getUser());
        laptop.setStatus(laptopDto.getStatus());
        laptop.setName(laptopDto.getName());
        laptop.setType(laptopDto.getType());
        laptop.setYear(laptopDto.getYear());
        laptop.setBrand(laptopDto.getBrand());
        laptop.setOs(laptopDto.getOs());
        laptop.setModel(laptopDto.getModel());
        laptop.setProcessorname(laptopDto.getProcessorname());
        laptop.setProcessordetails(laptopDto.getProcessordetails());
        laptop.setProcessorgeneration(laptopDto.getProcessorgeneration());
        laptop.setChipset(laptopDto.getChipset());
        laptop.setRamtype(laptopDto.getRamtype());
        laptop.setRamcapacity(laptopDto.getRamcapacity());
        laptop.setRamslotstype(laptopDto.getRamslotstype());
        laptop.setRamslotscount(laptopDto.getRamslotscount());
        laptop.setStoragefirst(laptopDto.getStoragefirst());
        laptop.setStoragefirstcapacity(laptopDto.getStoragefirstcapacity());
        laptop.setStoragesecond(laptopDto.getStoragesecond());
        laptop.setStoragesecondcapacity(laptopDto.getStoragesecondcapacity());
        laptop.setDisplaysizeresolution(laptopDto.getDisplaysizeresolution());
        laptop.setDisplayrefreshrate(laptopDto.getDisplayrefreshrate());
        laptop.setDisplaytype(laptopDto.getDisplaytype());
        laptop.setGraphicbrand(laptopDto.getGraphicbrand());
        laptop.setGraphicmodel(laptopDto.getGraphicmodel());
        laptop.setGraphiccapacity(laptopDto.getGraphiccapacity());
        laptop.setGraphicdetails(laptopDto.getGraphicdetails());
        laptop.setWebcam(laptopDto.getWebcam());
        laptop.setKeyboard(laptopDto.getKeyboard());
        laptop.setCommunication(laptopDto.getCommunication());
        laptop.setAudio(laptopDto.getAudio());
        laptop.setIoports(laptopDto.getIoports());
        laptop.setBattery(laptopDto.getBattery());
        laptop.setDimension(laptopDto.getDimension());
        laptop.setWeight(laptopDto.getWeight());
        laptop.setColor(laptopDto.getColor());

        return laptopApi.updateLaptop(laptop);
    }

    @PutMapping("/update-status")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptopStatus(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = new Laptop();

        laptop.setId(laptopDto.getId());
        laptop.setStatus(laptopDto.getStatus());

        return laptopApi.updateLaptopStatus(laptop);
    }

    @GetMapping("/get-by-status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopByStatus(@PathVariable String status) {
        return laptopApi.getLaptopByStatus(status);
    }

    @GetMapping("/get-object-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LaptopModel getLaptopObjectById(@PathVariable String id) {
        return laptopApi.getLaptopObjectById(id);
    }

    @PutMapping("/update-image")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptopImage(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = new Laptop();

        laptop.setId(laptopDto.getId());
        laptop.setImage(laptopDto.getImage());

        return laptopApi.updateLaptopImage(laptop);
    }

    @DeleteMapping("/delete-selected")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteAllLaptop(@RequestParam("ids") List<String> ids) {
        return laptopApi.deleteAllLaptop(ids);
    }

    @GetMapping("/get-by-brand/{brand}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopByBrandActivated(@PathVariable String brand) {
        return laptopApi.getLaptopByBrandActivated(brand);
    }

    @GetMapping("/get-by-ram/{ram}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopByRamCapacityActivated(@PathVariable String ram) {
        return laptopApi.getLaptopByRamCapacityActivated(ram);
    }

    @GetMapping("/get-by-processor/{processor}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopByProcessorNameActivated(@PathVariable String processor) {
        return laptopApi.getLaptopByProcessorNameActivated(processor);
    }
}
