package com.spm.netgarage.domain.laptop;

import java.util.List;

public interface LaptopBrandDataAdapter {

    LaptopBrand save(LaptopBrand laptopBrand);

    List<LaptopBrand> getAll();

    void deleteById(String id);

    LaptopBrand update(LaptopBrand laptopBrand);

    List<LaptopBrand> getById(String id);
}
