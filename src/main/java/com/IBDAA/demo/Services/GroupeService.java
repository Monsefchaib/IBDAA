package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Repositorys.FormationRepository;
import com.IBDAA.demo.Repositorys.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class GroupeService {
    private final GroupeRepository repository;

    @Autowired
    public GroupeService(GroupeRepository repository) {
        this.repository = repository;
    }
    public List<Groupe> getGroups(){
        return repository.findAll();
    }
    public Groupe getGroupById(Long id){
         return repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Group does not exist"));
        //return group;
    }
    public void createGroup(Groupe group){
        repository.save(group);
    }
    public void removeGroup(Long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("the Group with the id " + id + " does not exist") ;
        }
        repository.deleteById(id);
    }
    @Transactional
    public void updateGroup(Groupe gp){
         Groupe group= repository.findById(gp.getId())
                .orElseThrow(()->new IllegalStateException("Group does not exist"));
         if (gp.getCandidats() !=null){
             group.setCandidats(gp.getCandidats());
         }
    }
}


