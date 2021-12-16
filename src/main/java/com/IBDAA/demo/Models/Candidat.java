package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="CANDIDAT")
@PrimaryKeyJoinColumn(name = "user_id")
public @Data
class Candidat extends Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String type;


    @JsonBackReference
    @JoinColumn(name = "CANDIDAT_GROUPE")
    @ManyToOne
    Groupe groupe;

}

