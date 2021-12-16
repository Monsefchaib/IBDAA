package com.IBDAA.demo.Repositorys;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Models.Sceance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SceanceRepository extends JpaRepository<Sceance,Long> {
    @Query("SELECT c FROM Sceance  c WHERE c.formation.id=:formationid")
    List<Sceance> getformationSession(@Param("formationid") Long formationid);

    @Query("SELECT c.formation.id FROM Sceance  c WHERE c.id=:id")
    Long getformationid(@Param("id") Long id);

}