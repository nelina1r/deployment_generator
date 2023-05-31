package ru.zharkov.deployment_generator.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileCreationService {

    public ResponseEntity<FileSystemResource> createDeploymentFile(String content){

        try {
            // Создаем временный файл
            File tempFile = File.createTempFile("deployment", ".yaml");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(content);
            writer.close();

            // Устанавливаем заголовки ответа
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=deployment.yaml");

            // Возвращаем файл в качестве ресурса
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(tempFile.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new FileSystemResource(tempFile));
        } catch (IOException e) {
            e.printStackTrace();
            // Обработка ошибки, если что-то пошло не так
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }
}
