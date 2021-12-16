package com.IBDAA.demo.Repositorys;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat,Long> {

    @Query("SELECT c FROM Candidat c WHERE c.groupe.id=:groupid")
    List<Candidat> getcandidatgroup(@Param("groupid") Long groupid);
    @Transactional
    @Modifying
    @Query("UPDATE Candidat SET groupe.id=null WHERE id=:idcandidat")
    void updatecandidatgroup(@Param("idcandidat") Long idcandidat);
    @Transactional
    @Modifying
    @Query("UPDATE Candidat SET groupe.id=:newgroup WHERE id=:idcandidat AND groupe IS NULL")
    void updatecandidatnewgroup(@Param("idcandidat") Long idcandidat,@Param("newgroup") Long newgroup);
    @Query("SELECT c FROM Candidat c WHERE c.nom LIKE concat('%', :name , '%') AND c.groupe IS NULL")
    List<Candidat> getCadidatByName(@Param("name") String name);
}
