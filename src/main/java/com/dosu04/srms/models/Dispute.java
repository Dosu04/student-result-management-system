package com.dosu04.srms.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "disputes")
public class Dispute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String name;

    private String otherName;

    private String courseLecturer;

    private String complaint;

    private LocalDateTime createdAt = LocalDateTime.now();;

}
