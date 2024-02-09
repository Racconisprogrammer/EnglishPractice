package com.trustmeenglish.learnenglish.controllers;

import com.trustmeenglish.learnenglish.dto.CardDTO;
import com.trustmeenglish.learnenglish.dto.ImageDTO;
import com.trustmeenglish.learnenglish.entity.Card;
import com.trustmeenglish.learnenglish.entity.Image;
import com.trustmeenglish.learnenglish.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;


    @GetMapping("/images/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        Image image = imageService.getImage(id);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFilename())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

    @PostMapping("/images")
    public ResponseEntity<?> savedCard(@RequestParam("file") MultipartFile file) {
        Image image = toEntity(file);
        image = imageService.saveImage(image);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("fileName", image.getOriginalFilename())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

    private ImageDTO imageDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .name(image.getName())
                .originalFilename(image.getOriginalFilename())
                .contentType(image.getContentType())
                .size(image.getSize())
                .bytes(image.getBytes())
                .build();
    }

    private Image toEntity(MultipartFile file) {
        Image image = new Image();
        try {
            image.setName(file.getName());
            image.setOriginalFilename(file.getOriginalFilename());
            image.setContentType(file.getContentType());
            image.setSize(file.getSize());
            image.setBytes(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
