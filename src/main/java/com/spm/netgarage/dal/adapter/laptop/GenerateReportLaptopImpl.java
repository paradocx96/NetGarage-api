package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.domain.laptop.LaptopGenerateReport;
import com.spm.netgarage.domain.laptop.Laptop;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.List;

@Component
public class GenerateReportLaptopImpl implements LaptopGenerateReport {

    @Override
    public ByteArrayInputStream laptopReport(List<Laptop> laptopList) {
        return null;
    }
}
