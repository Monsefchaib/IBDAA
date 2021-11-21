package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(mappedBy = "groupe",cascade= CascadeType.MERGE)
    List<Candidat> candidats;
    @Column(unique = true)
    String nom;
    String Description;
    @OneToMany(mappedBy = "groupe", cascade = CascadeType.MERGE)
    List<Sceance> sceances;
}
