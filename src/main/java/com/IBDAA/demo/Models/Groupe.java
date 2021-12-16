package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Groupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "groupe")
    List<Candidat> candidats;
    @Column(unique = true)
    String nom;
    String Description;

    @OneToMany(mappedBy = "groupe")
    List<Sceance> sceances;
}
