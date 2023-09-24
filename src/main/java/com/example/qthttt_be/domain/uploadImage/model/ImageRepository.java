package com.example.qthttt_be.domain.uploadImage.model;

import com.example.qthttt_be.domain.uploadImage.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageData, Long> {
    ImageData getById(Long Id);
}
