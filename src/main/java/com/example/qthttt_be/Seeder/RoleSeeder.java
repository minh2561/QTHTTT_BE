package com.example.qthttt_be.Seeder;

import com.example.qthttt_be.Seeder.Enum.RoleEnum;
import com.example.qthttt_be.domain.user.RoleRepository;
import com.example.qthttt_be.domain.user.entity.RoleEntity;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Nguyễn Tuấn Minh
 */
@Component
public class RoleSeeder {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void run() {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (!roleRepository.existsByRole(roleEnum.getRole())) {
                RoleEntity roleEntity = modelMapper.map(roleEnum.getRole(), RoleEntity.class);
                roleEntity.setRole(roleEnum.getRole());
                roleRepository.save(roleEntity);
            }
        }
    }
}
