package com.amaan;

public class PdfDocumentFactory extends WordDocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
