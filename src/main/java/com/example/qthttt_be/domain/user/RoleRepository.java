package com.example.qthttt_be.domain.user;

import com.example.qthttt_be.domain.user.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nguyễn Tuấn Minh
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRole(String role);

    Boolean existsByRole(String role);
}
