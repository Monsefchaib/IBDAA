package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="CANDIDAT")
@PrimaryKeyJoinColumn(name = "user_id")
public @Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
class Candidat extends Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String type;

    @JsonManagedReference
    @ManyToMany
    List<Formation> formationsCandidat;

    @JsonBackReference
    @JoinColumn(name ="CANDIDAT_GROUPE")
    @ManyToOne
    Groupe groupe;

}

