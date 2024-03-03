package com.fiappostech.burgerbox.infraestructure.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Hidden
@RestController
public class RedocController {
    @GetMapping("/redoc")
    public ResponseEntity<String> redoc() throws IOException {
        Resource resource = new ClassPathResource("static/redoc.html");

        byte[] htmlBytes = Files.readAllBytes(resource.getFile().toPath());
        String htmlContent = new String(htmlBytes, StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlContent);
    }
}