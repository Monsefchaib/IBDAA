package com.IBDAA.demo.Models;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToMany(mappedBy = "groupe",cascade= CascadeType.ALL)
    List<Candidat> candidats;
    String nom;
    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    List<Sceance> sceances;
}
