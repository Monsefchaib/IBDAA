package com.IBDAA.demo.Models;


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

    String dureeDebut;
    String dureeFin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime dateFin;

    @JoinColumn(name="SCEANCE_FORMATEUR")
    @ManyToOne
    Formateur sceanceFormateur;

    @ManyToOne
    @JoinColumn(name="SCEANCE_FORMATION")
    Formation formation;

    @ManyToOne
    @JoinColumn(name = "SCENACE_GROUPE")
    Groupe groupe;




}
