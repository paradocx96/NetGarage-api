package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopModel;
import com.spm.netgarage.dal.repository.laptop.LaptopRepository;
import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.domain.laptop.LaptopDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class LaptopAdapterMongoImpl implements LaptopDataAdapter {

    private final LaptopRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopAdapterMongoImpl(LaptopRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Laptop save(Laptop laptop) {
        LaptopModel laptopModel = new LaptopModel();

        laptopModel.setUser(laptop.getUser());
        laptopModel.setDatetime(LocalDateTime.now());
        laptopModel.setStatus("Deactivate");
        laptopModel.setName(laptop.getName());
        laptopModel.setYear(laptop.getYear());
        laptopModel.setBrand(laptop.getBrand());
        laptopModel.setOs(laptop.getOs());
        laptopModel.setModel(laptopModel.getModel());
        laptopModel.setProcessorname(laptopModel.getProcessorname());
        laptopModel.setProcessordetails(laptopModel.getProcessordetails());
        laptopModel.setProcessorgeneration(laptopModel.getProcessorgeneration());
        laptopModel.setChipset(laptopModel.getChipset());
        laptopModel.setRamtype(laptopModel.getRamtype());
        laptopModel.setRamcapacity(laptopModel.getRamcapacity());
        laptopModel.setRamslotstype(laptopModel.getRamslotstype());
        laptopModel.setRamslotscount(laptopModel.getRamslotscount());
        laptopModel.setStoragefirst(laptopModel.getStoragefirst());
        laptopModel.setStoragefirstcapacity(laptopModel.getStoragefirstcapacity());
        laptopModel.setStoragesecond(laptopModel.getStoragesecond());
        laptopModel.setStoragesecondcapacity(laptopModel.getStoragesecondcapacity());
        laptopModel.setDisplaysizeresolution(laptopModel.getDisplaysizeresolution());
        laptopModel.setDisplayrefreshrate(laptopModel.getDisplayrefreshrate());
        laptopModel.setDisplaytype(laptopModel.getDisplaytype());
        laptopModel.setGraphicbrand(laptopModel.getGraphicbrand());
        laptopModel.setGraphicmodel(laptopModel.getGraphicmodel());
        laptopModel.setGraphiccapacity(laptopModel.getGraphiccapacity());
        laptopModel.setGraphicdetails(laptopModel.getGraphicdetails());
        laptopModel.setWebcam(laptopModel.getWebcam());
        laptopModel.setKeyboard(laptopModel.getKeyboard());
        laptopModel.setCommunication(laptopModel.getCommunication());
        laptopModel.setAudio(laptopModel.getAudio());
        laptopModel.setIoports(laptopModel.getIoports());
        laptopModel.setBattery(laptopModel.getBattery());
        laptopModel.setDimension(laptopModel.getDimension());
        laptopModel.setWeight(laptopModel.getWeight());
        laptopModel.setColor(laptopModel.getColor());

        // Saving model data in database
        laptopModel = repository.save(laptopModel);

        // Assign auto generated key to object and return object
        laptop.setId(laptopModel.getId());

        return laptop;
    }

    @Override
    public List<Laptop> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        return null;
    }

    @Override
    public Laptop update(Laptop laptop) {
        return null;
    }

    @Override
    public List<Laptop> getById(String id) {
        return null;
    }

    @Override
    public Laptop updateStatus(Laptop laptop) {
        return null;
    }

    @Override
    public List<Laptop> getByStatus(String status) {
        return null;
    }
}
