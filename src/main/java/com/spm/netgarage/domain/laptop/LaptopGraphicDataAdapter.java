package com.spm.netgarage.domain.laptop;

import java.util.List;

public interface LaptopGraphicDataAdapter {

    LaptopGraphic save(LaptopGraphic laptopGraphic);

    List<LaptopGraphic> getAll();

    void deleteById(String id);

    LaptopGraphic update(LaptopGraphic laptopGraphic);

    List<LaptopGraphic> getById(String id);
}
