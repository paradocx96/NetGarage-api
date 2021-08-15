package com.spm.netgarage.domain.laptop;

import java.util.List;

public interface LaptopProcessorDataAdapter {

    LaptopProcessor save(LaptopProcessor laptopProcessor);

    List<LaptopProcessor> getAll();

    void deleteById(String id);

    LaptopProcessor update(LaptopProcessor laptopProcessor);

    List<LaptopProcessor> getById(String id);
}
