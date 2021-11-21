package com.IBDAA.demo.Repositorys;

import com.IBDAA.demo.Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
