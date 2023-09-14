//package com.example.qthttt_be.domain.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.sql.Date;
//import java.sql.Timestamp;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "TBL_FILMS")
//public class Films {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_FILM")
//    private Integer idFilm;
//
//    @Column(name = "NAME_FILM")
//    private String nameFilm;
//
//    @Column(name = "DIRECTOR")
//    private String director;
//
//    @Column(name = "CASTS")
//    private String casts;
//
//    @Column(name = "OPENING_DAY")
//    private Date openingDay;
//
//    @Column(name = "DURATION")
//    private int duration;
//
//    @Column(name = "DESCRIPTION")
//    private String description;
//
//    @Column(name = "STATUS")
//    private boolean status;
//
//    @Column(name = "COUNTRY")
//    private String country;
//
//    @Column(name = "GENRE")
//    private String genre;
//
//    @CreationTimestamp
//    @Column(name = "CREATED_DATE")
//    private Timestamp createdDate;
//
//    @UpdateTimestamp
//    @Column(name = "UPDATED_DATE")
//    private Timestamp updatedDate;
//}
