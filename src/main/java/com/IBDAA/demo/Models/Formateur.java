package com.IBDAA.demo.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "user_id")
public class Formateur extends Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



}
