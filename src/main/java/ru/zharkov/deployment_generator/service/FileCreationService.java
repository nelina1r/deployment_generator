package ru.zharkov.deployment_generator.service;

import lombok.extern.java.Log;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Log
public class FileCreationService {

    public ResponseEntity<FileSystemResource> createDeploymentFile(String content, String filePrefix){
        log.warning("в методе с файлом");
        try {
            File tempFile = File.createTempFile(filePrefix, ".yaml");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(content);
            writer.close();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filePrefix + ".yaml");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(tempFile.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new FileSystemResource(tempFile));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }
}
