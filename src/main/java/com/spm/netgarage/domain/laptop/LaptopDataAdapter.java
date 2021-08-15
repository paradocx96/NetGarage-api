package com.spm.netgarage.domain.laptop;

import java.util.List;

public interface LaptopDataAdapter {

    Laptop save(Laptop laptop);

    List<Laptop> getAll();

    void deleteById(String id);

    Laptop update(Laptop laptop);

    List<Laptop> getById(String id);

    Laptop updateStatus(Laptop laptop);

    List<Laptop> getByStatus(String status);
}
