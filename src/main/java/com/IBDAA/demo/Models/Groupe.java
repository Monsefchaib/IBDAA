package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Groupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @JsonManagedReference
    @OneToMany(mappedBy = "groupe")
    List<Candidat> candidats;
    @Column(unique = true)
    String nom;
    String Description;

    @JsonManagedReference(value = "firstParent")
    @OneToMany(mappedBy = "groupe")
    List<Sceance> sceances;
}
