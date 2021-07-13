package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Repositorys.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class FormationService {
    private final FormationRepository repository;

    @Autowired
    public FormationService(FormationRepository repository) {
        this.repository = repository;
    }

    public List<Formation> getFormation(){
        return repository.findAll();
    }
    public void createFormation(Formation formation){
        repository.save(formation);
    }
    public void removeFormation(Long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("the Formation with the id " + id + " does not exist") ;
        }
        repository.deleteById(id);
    }
    @Transactional
    public void updateFormation(Long formationId,String name,String type,Integer duration,String desc,String status){
        Formation formation= repository.findById(formationId)
                .orElseThrow(()->new IllegalStateException("Formation does not exist"));

        if(name != null && name.length()>0 && !Objects.equals(formation.getNom(),name)){
            formation.setNom(name);
        }
        if(type != null && type.length()>0 && !Objects.equals(formation.getType(),type)){
            formation.setType(type);
        }
        if(duration != null && duration>0 && !Objects.equals(formation.getDuree(),duration)){
            formation.setDuree(duration);
        }
        if(desc != null && desc.length()>0 && !Objects.equals(formation.getDescription(),desc)){
            formation.setDescription(desc);
        }
        if(status != null && status.length()>0 && !Objects.equals(formation.getEtat(),status)){
            formation.setEtat(status);
        }

    }

}
