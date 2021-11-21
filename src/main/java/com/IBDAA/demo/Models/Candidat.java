package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="CANDIDAT")
@PrimaryKeyJoinColumn(name = "user_id")
public @Data
class Candidat extends Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String type;

    @JsonManagedReference
    @ManyToMany
    List<Formation> formationsCandidat;

    @JoinColumn(name ="CANDIDAT_GROUPE")
    @ManyToOne
    Groupe groupe;

}

