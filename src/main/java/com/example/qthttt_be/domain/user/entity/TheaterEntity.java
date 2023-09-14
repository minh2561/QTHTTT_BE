//package com.example.qthttt_be.domain.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.sql.Timestamp;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "TBL_THEATER")
//public class Theater {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_THEATER")
//    private Integer idTheater;
//
//    @Column(name = "NAME_THEATER")
//    private String nameTheater;
//
//    @Column(name = "ADDRESS")
//    private String address;
//
//    @Column(name = "HOT_LINE")
//    private int hotLine;
//
//    @CreationTimestamp
//    @Column(name = "CREATED_DATE")
//    private Timestamp createdDate;
//
//    @UpdateTimestamp
//    @Column(name = "UPDATED_DATE")
//    private Timestamp updatedDate;
//}
