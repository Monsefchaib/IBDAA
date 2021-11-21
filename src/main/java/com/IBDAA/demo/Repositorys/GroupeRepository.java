package com.IBDAA.demo.Repositorys;


import com.IBDAA.demo.Models.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe,Long> {

    @Query("SELECT g FROM Groupe g WHERE g.nom LIKE concat('%', :name , '%') AND g.Description LIKE concat('%', :description , '%')")
    List<Groupe> CustomSearch(@Param("name") String name,@Param("description") String description);
    @Query("SELECT g FROM Groupe g WHERE g.nom = concat('', :name , '')")
    Groupe GetGroupByName(@Param("name") String name);
}
