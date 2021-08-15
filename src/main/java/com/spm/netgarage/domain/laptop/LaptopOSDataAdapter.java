package com.spm.netgarage.domain.laptop;

import java.util.List;

public interface LaptopOSDataAdapter {

    LaptopOS save(LaptopOS laptopOS);

    List<LaptopOS> getAll();

    void deleteById(String id);

    LaptopOS update(LaptopOS laptopOS);

    List<LaptopOS> getById(String id);
}
