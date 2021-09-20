package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.domain.laptop.LaptopGenerateReport;
import com.spm.netgarage.domain.laptop.Laptop;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class GenerateReportLaptopImpl implements LaptopGenerateReport {

    @Override
    public ByteArrayInputStream laptopReport(List<Laptop> laptopList) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{2, 3, 1, 1, 1, 2});

            // 1st Heading
            Font heading = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            heading.setSize(20);
            heading.setColor(BaseColor.BLUE);
            Paragraph mainTitle = new Paragraph("NetGarage\n\n", heading);
            mainTitle.setAlignment(Paragraph.ALIGN_LEFT);

            // 2nd Heading
            Font heading2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            heading2.setSize(15);
            heading2.setColor(BaseColor.RED);
            Paragraph secondTitle = new Paragraph("All Laptops\n\n", heading2);
            secondTitle.setAlignment(Paragraph.ALIGN_LEFT);

            // Table Style
            Font headFont = FontFactory.getFont(FontFactory.TIMES);
            headFont.setSize(10);

            // Date
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Calendar dateTime = Calendar.getInstance();
            Font dateLine = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            dateLine.setSize(10);
            dateLine.setColor(BaseColor.DARK_GRAY);
            Paragraph date = new Paragraph("Date : " + dateFormat.format(dateTime.getTime()), dateLine);
            date.setAlignment(Paragraph.ALIGN_LEFT);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("NAME", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("YEAR", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("STATUS", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("CREATED BY", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("CREATED DATE", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (Laptop laptop : laptopList) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(laptop.getId(), headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(laptop.getBrand() + ' ' + laptop.getName() + ' ' + laptop.getModel(), headFont));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(laptop.getYear()), headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(laptop.getStatus(), headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(laptop.getUser(), headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(laptop.getDatetime()), headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(mainTitle);
            document.add(secondTitle);
            document.add(table);
            document.add(date);
            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(GenerateReportLaptopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
