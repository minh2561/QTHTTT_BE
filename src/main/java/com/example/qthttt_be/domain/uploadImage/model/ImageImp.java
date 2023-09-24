package com.example.qthttt_be.domain.uploadImage.model;

import com.example.qthttt_be.domain.uploadImage.entity.ImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Component
public class ImageImp implements ImageService {
    private ImageRepository imageRepository;

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageData saveImage(MultipartFile image) throws IOException {
        if (image == null || image.isEmpty() || image.getOriginalFilename() == null) {
            throw new IllegalArgumentException("MultipartFile is null or empty.");
        }
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        String originalFilename = image.getOriginalFilename();
        String timestamp = String.valueOf(System.currentTimeMillis());
        int randomNumber = new Random().nextInt(1_000_000_000);
        String newFilename = timestamp + randomNumber + "_" + originalFilename;
        if (!Files.exists(staticPath.resolve(imagePath))) {
            Files.createDirectories(staticPath.resolve(imagePath));
        }
        Path filePath = staticPath.resolve(imagePath).resolve(newFilename);
        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(image.getBytes());
        }
        ImageData imageData = new ImageData();
        imageData.setImageName(image.getOriginalFilename());
        imageData.setImageType(image.getContentType());
//        imageData.setImagePath(imagePath.resolve(newFilename).toString());
        imageData.setImagePath(newFilename);
        return imageRepository.save(imageData);
    }

    @Override
    public List<ImageData> getAllImages() {
        //chua lam xong
        List<ImageData> allImages = imageRepository.findAll();
        for (ImageData image : allImages) {
            image.setImagePath("images/" + image.getImagePath());
        }
        return allImages;
    }
    @Override
    public void deleteImageById(Long id) throws IOException {
        ImageData imageData = imageRepository.getById(id);
        String imagePath = "static/images/" + imageData.getImagePath();
        imageRepository.delete(imageData);
        Path filePath = Paths.get(imagePath);
        Files.deleteIfExists(filePath);

    }
}
