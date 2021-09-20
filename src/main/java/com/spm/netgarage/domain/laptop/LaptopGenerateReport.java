package com.spm.netgarage.domain.laptop;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface LaptopGenerateReport {

    ByteArrayInputStream laptopReport(List<Laptop> laptopList);
}
