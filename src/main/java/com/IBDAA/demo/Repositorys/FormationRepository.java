package com.IBDAA.demo.Repositorys;

import com.IBDAA.demo.Models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {

}
