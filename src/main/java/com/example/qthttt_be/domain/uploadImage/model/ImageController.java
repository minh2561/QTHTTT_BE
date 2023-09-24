package com.example.qthttt_be.domain.uploadImage.model;

import com.example.qthttt_be.domain.uploadImage.entity.ImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/images")
public class ImageController {
    private ImageService imageService;

    @Autowired
    public void setImageRepository(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageData> uploadImage(@RequestParam("file") MultipartFile image) throws IOException {
        String fileName = image.getOriginalFilename().toUpperCase();
        if (fileName != null && (fileName.endsWith(".JPG") || fileName.endsWith(".JPEG") || fileName.endsWith(".PNG"))) {
            ImageData imageData = imageService.saveImage(image);
            return ResponseEntity.ok(imageData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ImageData>> getAllImage() throws IOException {
        return ResponseEntity.ok(imageService.getAllImages());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImageById(@PathVariable Long id) throws IOException {
        System.out.println("vao day");
        imageService.deleteImageById(id);
        return ResponseEntity.ok("Image with ID " + id + " has been deleted.");
    }
}

