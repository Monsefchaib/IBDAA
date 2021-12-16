package com.IBDAA.demo.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    String formateur;


    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
    LocalDateTime dateTimeDebut;
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
    LocalDateTime dateTimeFin;


    @JsonBackReference(value = "thirdParent")
    @ManyToOne
    @JoinColumn(name="SCEANCE_FORMATION")
    Formation formation;

    @JsonBackReference(value = "firstParent")
    @ManyToOne
    @JoinColumn(name = "SCENACE_GROUPE")
    Groupe groupe;




}
