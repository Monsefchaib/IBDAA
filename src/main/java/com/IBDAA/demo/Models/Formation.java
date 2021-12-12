package com.IBDAA.demo.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference(value = "thirdParent")
    @OneToMany(mappedBy ="formation",cascade= CascadeType.ALL )
    List<Sceance> formationSceances;

    @JsonBackReference
    @ManyToMany
    List<Candidat> candidats;
}
