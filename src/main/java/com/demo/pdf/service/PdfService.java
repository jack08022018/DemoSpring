package com.demo.pdf.service;

import com.demo.pdf.PdfCommonUtils;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Table;

public class PdfService {
    public static void addMetadata(PdfDocument doc) {
        PdfDocumentInfo info = doc.getDocumentInfo();
        info.setAuthor("Jack");
        info.addCreationDate();
    }

    public static void buildCaution(Document doc, ConverterProperties converterFont) {
        String css = "" +
                "color: red;" +
                "border: 1px solid black;" +
                "margin: 10 0 0 0;" +
                "font: italic 14px verdana;" +
                "padding: 5px;";
        String html = "" +
                "<div style='" + css + "'>" +
                    "<b>LƯU Ý:</b> việc kê khai đầy đủ và trung thực các thông tin dưới đây" +
                "</div>";
        doc.add((Div) PdfCommonUtils.getElementFromHtml(html, converterFont));
    }
}
