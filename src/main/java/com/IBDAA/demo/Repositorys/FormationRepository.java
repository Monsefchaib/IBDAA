package com.IBDAA.demo.Repositorys;

import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Models.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {
    @Query("SELECT f FROM Formation f WHERE f.nom = concat('', :name , '')")
    Formation GetFormationByName(@Param("name") String name);
}
