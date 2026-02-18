package com.example.ocr_demo.controllers;

import com.example.ocr_demo.service.OCRService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController //This class handles HTTP requests and returns JSON/text responses.
@RequestMapping("/ocr") //All endpoints in this controller will start with:http://localhost:8080/ocr
public class OCRController {
//Dependency Injection To ensure the flow is Controller ➝ Service ➝ Tesseract ➝ Extract Text
    private final OCRService ocrService;

    public OCRController(OCRService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("/scan")//Main Endpoint
    public ResponseEntity<String> scanId(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }

        File tempFile = null;
        try {
            // Preserve original extension
            String originalName = file.getOriginalFilename();
            String ext = ".tmp";
            if (originalName != null && originalName.contains(".")) {
                ext = originalName.substring(originalName.lastIndexOf("."));
            }

            // Create temp file and save uploaded file
            tempFile = File.createTempFile("id-", ext);
            file.transferTo(tempFile);

            // Run OCR (This calls my service layer:)
            String text = ocrService.extractText(tempFile);

            return ResponseEntity.ok(text);//Returning the Result

        } catch (IOException ioEx) //input output exception eg File cannot be created
        {
            ioEx.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("File handling error: " + ioEx.getMessage());
        } catch (Exception ex) //captures any other exception that's not IO eg server crash
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("OCR processing error: " + ex.getMessage());
        } finally {
            // Clean up temp file
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }


    @GetMapping("/test")
    public String test() {
        return "OCR API is alive";
    }
}
