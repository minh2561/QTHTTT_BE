package com.example.qthttt_be.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Nguyễn Tuấn Minh
 */
@Entity
@Getter
@Setter
@Table(name = "TBL_ROLE")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROLE")
    private Integer idRole;

    @Column(name = "ROLE")
    private String role;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    private Timestamp updatedDate;

    @OneToMany(mappedBy = "roleEntity", cascade = CascadeType.ALL)
    private List<UserEntity> userEntities;
}
