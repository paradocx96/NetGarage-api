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
        return null;
    }

    public List<LaptopGraphic> getAllLaptopGraphic() {
        return null;
    }

    public List<LaptopGraphic> getLaptopGraphicById(String id) {
        return null;
    }

    public LaptopGraphic updateLaptopGraphic(LaptopGraphic laptopGraphic) {
        return null;
    }

    public ResponseEntity<?> deleteLaptopGraphicById(String id) {
        return null;
    }
}
