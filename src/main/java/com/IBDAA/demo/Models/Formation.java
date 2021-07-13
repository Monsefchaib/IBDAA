package com.IBDAA.demo.Models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String type;
    Integer duree;
    String description;
    String etat;

    @OneToMany(mappedBy ="formation",cascade= CascadeType.ALL )
    List<Sceance> formationSceances;

    @ManyToMany
    List<Candidat> candidats;
}
