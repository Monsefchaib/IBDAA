package com.IBDAA.demo.Models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Formateur extends Utilisateur {

    @OneToMany(mappedBy = "sceanceFormateur",cascade= CascadeType.ALL)
    List<Sceance> sceances;

}
