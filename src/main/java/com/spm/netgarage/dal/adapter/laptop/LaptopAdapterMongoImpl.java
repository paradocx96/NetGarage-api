package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopModel;
import com.spm.netgarage.dal.repository.laptop.LaptopRepository;
import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.domain.laptop.LaptopDataAdapter;
import com.spm.netgarage.dto.MessageResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        laptopModel.setStatus(laptop.getStatus());
        laptopModel.setName(laptop.getName());
        laptopModel.setType(laptop.getType());
        laptopModel.setYear(laptop.getYear());
        laptopModel.setBrand(laptop.getBrand());
        laptopModel.setOs(laptop.getOs());
        laptopModel.setModel(laptop.getModel());
        laptopModel.setProcessorname(laptop.getProcessorname());
        laptopModel.setProcessordetails(laptop.getProcessordetails());
        laptopModel.setProcessorgeneration(laptop.getProcessorgeneration());
        laptopModel.setChipset(laptop.getChipset());
        laptopModel.setRamtype(laptop.getRamtype());
        laptopModel.setRamcapacity(laptop.getRamcapacity());
        laptopModel.setRamslotstype(laptop.getRamslotstype());
        laptopModel.setRamslotscount(laptop.getRamslotscount());
        laptopModel.setStoragefirst(laptop.getStoragefirst());
        laptopModel.setStoragefirstcapacity(laptop.getStoragefirstcapacity());
        laptopModel.setStoragesecond(laptop.getStoragesecond());
        laptopModel.setStoragesecondcapacity(laptop.getStoragesecondcapacity());
        laptopModel.setDisplaysizeresolution(laptop.getDisplaysizeresolution());
        laptopModel.setDisplayrefreshrate(laptop.getDisplayrefreshrate());
        laptopModel.setDisplaytype(laptop.getDisplaytype());
        laptopModel.setGraphicbrand(laptop.getGraphicbrand());
        laptopModel.setGraphicmodel(laptop.getGraphicmodel());
        laptopModel.setGraphiccapacity(laptop.getGraphiccapacity());
        laptopModel.setGraphicdetails(laptop.getGraphicdetails());
        laptopModel.setWebcam(laptop.getWebcam());
        laptopModel.setKeyboard(laptop.getKeyboard());
        laptopModel.setCommunication(laptop.getCommunication());
        laptopModel.setAudio(laptop.getAudio());
        laptopModel.setIoports(laptop.getIoports());
        laptopModel.setBattery(laptop.getBattery());
        laptopModel.setDimension(laptop.getDimension());
        laptopModel.setWeight(laptop.getWeight());
        laptopModel.setColor(laptop.getColor());

        // Saving model data in database
        laptopModel = repository.save(laptopModel);
        laptop.setId(laptopModel.getId());
        laptop.setDatetime(laptopModel.getDatetime());

        return laptop;
    }

    @Override
    public List<Laptop> getAll() {
        List<LaptopModel> laptopModels = repository.findAll();
        List<Laptop> laptops = new ArrayList<>();

        for (LaptopModel laptopModel : laptopModels) {
            Laptop laptop = new Laptop();

            laptop.setId(laptopModel.getId());
            laptop.setUser(laptopModel.getUser());
            laptop.setDatetime(laptopModel.getDatetime());
            laptop.setStatus(laptopModel.getStatus());
            laptop.setName(laptopModel.getName());
            laptop.setType(laptopModel.getType());
            laptop.setYear(laptopModel.getYear());
            laptop.setBrand(laptopModel.getBrand());
            laptop.setOs(laptopModel.getOs());
            laptop.setModel(laptopModel.getModel());
            laptop.setProcessorname(laptopModel.getProcessorname());
            laptop.setProcessordetails(laptopModel.getProcessordetails());
            laptop.setProcessorgeneration(laptopModel.getProcessorgeneration());
            laptop.setChipset(laptopModel.getChipset());
            laptop.setRamtype(laptopModel.getRamtype());
            laptop.setRamcapacity(laptopModel.getRamcapacity());
            laptop.setRamslotstype(laptopModel.getRamslotstype());
            laptop.setRamslotscount(laptopModel.getRamslotscount());
            laptop.setStoragefirst(laptopModel.getStoragefirst());
            laptop.setStoragefirstcapacity(laptopModel.getStoragefirstcapacity());
            laptop.setStoragesecond(laptopModel.getStoragesecond());
            laptop.setStoragesecondcapacity(laptopModel.getStoragesecondcapacity());
            laptop.setDisplaysizeresolution(laptopModel.getDisplaysizeresolution());
            laptop.setDisplayrefreshrate(laptopModel.getDisplayrefreshrate());
            laptop.setDisplaytype(laptopModel.getDisplaytype());
            laptop.setGraphicbrand(laptopModel.getGraphicbrand());
            laptop.setGraphicmodel(laptopModel.getGraphicmodel());
            laptop.setGraphiccapacity(laptopModel.getGraphiccapacity());
            laptop.setGraphicdetails(laptopModel.getGraphicdetails());
            laptop.setWebcam(laptopModel.getWebcam());
            laptop.setKeyboard(laptopModel.getKeyboard());
            laptop.setCommunication(laptopModel.getCommunication());
            laptop.setAudio(laptopModel.getAudio());
            laptop.setIoports(laptopModel.getIoports());
            laptop.setBattery(laptopModel.getBattery());
            laptop.setDimension(laptopModel.getDimension());
            laptop.setWeight(laptopModel.getWeight());
            laptop.setColor(laptopModel.getColor());

            laptops.add(laptop);
        }
        return laptops;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        LaptopModel laptopModel = null;

        laptopModel = repository.findById(id).get();

        // Check Available or Not. Then Proceed Operation
        if (laptopModel == null) {
            return ResponseEntity.ok(new MessageResponseDto("Doesn't Exist!"));
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return ResponseEntity.ok(new MessageResponseDto("Deleted successfully!"));
        }
    }

    @Override
    public Laptop update(Laptop laptop) {
        LaptopModel laptopModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(laptop.getId())),
                new Update()
                        .set("user", laptop.getUser())
                        .set("status", laptop.getStatus())
                        .set("name", laptop.getName())
                        .set("type", laptop.getType())
                        .set("year", laptop.getYear())
                        .set("brand", laptop.getBrand())
                        .set("os", laptop.getOs())
                        .set("model", laptop.getModel())
                        .set("processorname", laptop.getProcessorname())
                        .set("processordetails", laptop.getProcessordetails())
                        .set("processorgeneration", laptop.getProcessorgeneration())
                        .set("chipset", laptop.getChipset())
                        .set("ramtype", laptop.getRamtype())
                        .set("ramcapacity", laptop.getRamcapacity())
                        .set("ramslotstype", laptop.getRamslotstype())
                        .set("ramslotscount", laptop.getRamslotscount())
                        .set("storagefirst", laptop.getStoragefirst())
                        .set("storagefirstcapacity", laptop.getStoragefirstcapacity())
                        .set("storagesecond", laptop.getStoragesecond())
                        .set("storagesecondcapacity", laptop.getStoragesecondcapacity())
                        .set("displaysizeresolution", laptop.getDisplaysizeresolution())
                        .set("displayrefreshrate", laptop.getDisplayrefreshrate())
                        .set("displaytype", laptop.getDisplaytype())
                        .set("graphicbrand", laptop.getGraphicbrand())
                        .set("graphicmodel", laptop.getGraphicmodel())
                        .set("graphiccapacity", laptop.getGraphiccapacity())
                        .set("graphicdetails", laptop.getGraphicdetails())
                        .set("webcam", laptop.getWebcam())
                        .set("keyboard", laptop.getKeyboard())
                        .set("communication", laptop.getCommunication())
                        .set("audio", laptop.getAudio())
                        .set("ioports", laptop.getIoports())
                        .set("battery", laptop.getBattery())
                        .set("dimension", laptop.getDimension())
                        .set("weight", laptop.getWeight())
                        .set("color", laptop.getColor()),
                LaptopModel.class
        );
        laptop.setDatetime(laptopModel.getDatetime());

        return laptop;
    }

    @Override
    public List<Laptop> getById(String id) {
        LaptopModel laptopModel = new LaptopModel();

        laptopModel = repository.findById(id).get();

        List<Laptop> laptopList = new ArrayList<>();

        Laptop laptop = new Laptop();

        laptop.setId(laptopModel.getId());
        laptop.setUser(laptopModel.getUser());
        laptop.setDatetime(laptopModel.getDatetime());
        laptop.setStatus(laptopModel.getStatus());
        laptop.setName(laptopModel.getName());
        laptop.setType(laptopModel.getType());
        laptop.setYear(laptopModel.getYear());
        laptop.setBrand(laptopModel.getBrand());
        laptop.setOs(laptopModel.getOs());
        laptop.setModel(laptopModel.getModel());
        laptop.setProcessorname(laptopModel.getProcessorname());
        laptop.setProcessordetails(laptopModel.getProcessordetails());
        laptop.setProcessorgeneration(laptopModel.getProcessorgeneration());
        laptop.setChipset(laptopModel.getChipset());
        laptop.setRamtype(laptopModel.getRamtype());
        laptop.setRamcapacity(laptopModel.getRamcapacity());
        laptop.setRamslotstype(laptopModel.getRamslotstype());
        laptop.setRamslotscount(laptopModel.getRamslotscount());
        laptop.setStoragefirst(laptopModel.getStoragefirst());
        laptop.setStoragefirstcapacity(laptopModel.getStoragefirstcapacity());
        laptop.setStoragesecond(laptopModel.getStoragesecond());
        laptop.setStoragesecondcapacity(laptopModel.getStoragesecondcapacity());
        laptop.setDisplaysizeresolution(laptopModel.getDisplaysizeresolution());
        laptop.setDisplayrefreshrate(laptopModel.getDisplayrefreshrate());
        laptop.setDisplaytype(laptopModel.getDisplaytype());
        laptop.setGraphicbrand(laptopModel.getGraphicbrand());
        laptop.setGraphicmodel(laptopModel.getGraphicmodel());
        laptop.setGraphiccapacity(laptopModel.getGraphiccapacity());
        laptop.setGraphicdetails(laptopModel.getGraphicdetails());
        laptop.setWebcam(laptopModel.getWebcam());
        laptop.setKeyboard(laptopModel.getKeyboard());
        laptop.setCommunication(laptopModel.getCommunication());
        laptop.setAudio(laptopModel.getAudio());
        laptop.setIoports(laptopModel.getIoports());
        laptop.setBattery(laptopModel.getBattery());
        laptop.setDimension(laptopModel.getDimension());
        laptop.setWeight(laptopModel.getWeight());
        laptop.setColor(laptopModel.getColor());

        laptopList.add(laptop);

        return laptopList;
    }

    @Override
    public Laptop updateStatus(Laptop laptop) {
        LaptopModel laptopModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(laptop.getId())),
                new Update()
                        .set("status", laptop.getStatus()),
                LaptopModel.class
        );

        if(laptopModel != null) {
            laptop.setId(laptopModel.getId());
            laptop.setStatus(laptopModel.getStatus());

            return laptop;
        } else {
            return null;
        }
    }

    @Override
    public List<Laptop> getByStatus(String status) {
        List<LaptopModel> laptopModels = repository.findByStatus(status);

        List<Laptop> laptops = new ArrayList<>();

        for (LaptopModel laptopModel : laptopModels) {
            Laptop laptop = new Laptop();

            laptop.setId(laptopModel.getId());
            laptop.setUser(laptopModel.getUser());
            laptop.setDatetime(laptopModel.getDatetime());
            laptop.setStatus(laptopModel.getStatus());
            laptop.setName(laptopModel.getName());
            laptop.setType(laptopModel.getType());
            laptop.setYear(laptopModel.getYear());
            laptop.setBrand(laptopModel.getBrand());
            laptop.setOs(laptopModel.getOs());
            laptop.setModel(laptopModel.getModel());
            laptop.setProcessorname(laptopModel.getProcessorname());
            laptop.setProcessordetails(laptopModel.getProcessordetails());
            laptop.setProcessorgeneration(laptopModel.getProcessorgeneration());
            laptop.setChipset(laptopModel.getChipset());
            laptop.setRamtype(laptopModel.getRamtype());
            laptop.setRamcapacity(laptopModel.getRamcapacity());
            laptop.setRamslotstype(laptopModel.getRamslotstype());
            laptop.setRamslotscount(laptopModel.getRamslotscount());
            laptop.setStoragefirst(laptopModel.getStoragefirst());
            laptop.setStoragefirstcapacity(laptopModel.getStoragefirstcapacity());
            laptop.setStoragesecond(laptopModel.getStoragesecond());
            laptop.setStoragesecondcapacity(laptopModel.getStoragesecondcapacity());
            laptop.setDisplaysizeresolution(laptopModel.getDisplaysizeresolution());
            laptop.setDisplayrefreshrate(laptopModel.getDisplayrefreshrate());
            laptop.setDisplaytype(laptopModel.getDisplaytype());
            laptop.setGraphicbrand(laptopModel.getGraphicbrand());
            laptop.setGraphicmodel(laptopModel.getGraphicmodel());
            laptop.setGraphiccapacity(laptopModel.getGraphiccapacity());
            laptop.setGraphicdetails(laptopModel.getGraphicdetails());
            laptop.setWebcam(laptopModel.getWebcam());
            laptop.setKeyboard(laptopModel.getKeyboard());
            laptop.setCommunication(laptopModel.getCommunication());
            laptop.setAudio(laptopModel.getAudio());
            laptop.setIoports(laptopModel.getIoports());
            laptop.setBattery(laptopModel.getBattery());
            laptop.setDimension(laptopModel.getDimension());
            laptop.setWeight(laptopModel.getWeight());
            laptop.setColor(laptopModel.getColor());

            laptops.add(laptop);
        }
        return laptops;
    }
}
