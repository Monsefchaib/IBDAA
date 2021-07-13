package com.IBDAA.demo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="CANDIDAT")
public @Data
class Candidat extends Utilisateur {

    String type;

    @ManyToMany
    List<Formation> formationsCandidat;

    @JoinColumn(name ="CANDIDAT_GROUPE")
    @ManyToOne
    Groupe groupe;

}
