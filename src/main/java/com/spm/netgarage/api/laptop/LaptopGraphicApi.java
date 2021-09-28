package com.spm.netgarage.api.laptop;

import com.spm.netgarage.domain.laptop.LaptopGraphic;
import com.spm.netgarage.domain.laptop.LaptopGraphicDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopGraphicApi {

    private final LaptopGraphicDataAdapter laptopGraphicDataAdapter;

    @Autowired
    public LaptopGraphicApi(LaptopGraphicDataAdapter laptopGraphicDataAdapter) {
        this.laptopGraphicDataAdapter = laptopGraphicDataAdapter;
    }

    public LaptopGraphic saveLaptopGraphic(LaptopGraphic laptopGraphic) {
        return laptopGraphicDataAdapter.save(laptopGraphic);
    }

    public List<LaptopGraphic> getAllLaptopGraphic() {
        return laptopGraphicDataAdapter.getAll();
    }

    public List<LaptopGraphic> getLaptopGraphicById(String id) {
        return laptopGraphicDataAdapter.getById(id);
    }

    public LaptopGraphic updateLaptopGraphic(LaptopGraphic laptopGraphic) {
        return laptopGraphicDataAdapter.update(laptopGraphic);
    }

    public ResponseEntity<?> deleteLaptopGraphicById(String id) {
        return laptopGraphicDataAdapter.deleteById(id);
    }

    public boolean checkAvailable(String name) {
        return laptopGraphicDataAdapter.findByName(name);
    }
}