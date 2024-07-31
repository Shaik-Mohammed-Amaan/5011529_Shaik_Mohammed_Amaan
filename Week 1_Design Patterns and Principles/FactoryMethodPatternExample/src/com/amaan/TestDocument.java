package com.amaan;

public class TestDocument {
    public static void testDocument() {
        DocumentFactory wordDocFac = new WordDocumentFactory();
        DocumentFactory pdfDocFac = new PdfDocumentFactory();
        DocumentFactory excelDocFac = new ExcelDocumentFactory();

        Document wordDoc = wordDocFac.createDocument();
        Document pdfDoc = pdfDocFac.createDocument();
        Document excelDoc = excelDocFac.createDocument();

        wordDoc.documentType();
        pdfDoc.documentType();
        excelDoc.documentType();
    }
}
