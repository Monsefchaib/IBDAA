package com.IBDAA.demo.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Sceance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateTimeDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateTimeFin;

    @JsonBackReference(value = "secondParent")
    @JoinColumn(name="SCEANCE_FORMATEUR")
    @ManyToOne
    Formateur sceanceFormateur;

    @JsonBackReference(value = "thirdParent")
    @ManyToOne
    @JoinColumn(name="SCEANCE_FORMATION")
    Formation formation;

    @JsonBackReference(value = "firstParent")
    @ManyToOne
    @JoinColumn(name = "SCENACE_GROUPE")
    Groupe groupe;




}
