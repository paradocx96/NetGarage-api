package com.spm.netgarage.domain.laptop;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopGraphicDataAdapter {

    LaptopGraphic save(LaptopGraphic laptopGraphic);

    List<LaptopGraphic> getAll();

    ResponseEntity<?> deleteById(String id);

    LaptopGraphic update(LaptopGraphic laptopGraphic);

    List<LaptopGraphic> getById(String id);
}
