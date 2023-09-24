package com.example.qthttt_be.domain.uploadImage.model;


import com.example.qthttt_be.domain.uploadImage.entity.ImageData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public interface ImageService {
    ImageData saveImage(MultipartFile file) throws IOException;

    List<ImageData> getAllImages() throws IOException;

    void deleteImageById(Long id) throws IOException;



}
