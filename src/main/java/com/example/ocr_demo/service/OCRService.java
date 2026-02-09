package com.example.ocr_demo.service;


import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OCRService {

    public String extractText(File image) throws Exception {

        Tesseract tesseract = new Tesseract();

        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
        tesseract.setLanguage("eng");

        return tesseract.doOCR(image);
    }
}
