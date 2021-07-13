package com.IBDAA.demo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data
class Candidat extends User{

    String type;

    @ManyToMany
    List<Formation> formationsCandidat;

    @JoinColumn(name ="CANDIDAT_GROUPE")
    @ManyToOne
    Groupe groupe;

}
