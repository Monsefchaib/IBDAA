package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Repositorys.CandidatRepository;
import com.IBDAA.demo.Repositorys.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IBDAA.demo.Type.CustomGroup;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupeService {

    private final GroupeRepository repository;
    private final CandidatRepository candidatrepository;


    @Autowired
    public GroupeService(GroupeRepository repository, CandidatRepository candidatrepo) {
        this.repository = repository;
        this.candidatrepository = candidatrepo;
    }
    public List<Groupe> getGroups(String name, String description){
        String n = name;
        String d = description;
        if(n == null && d == null){
            return repository.findAll();
        }
        if(n == null)
            n = "";
        if(d == null)
            d = "";
        return repository.CustomSearch(n,d);
    }
    public Groupe GetGroupByName(String name){
        return repository.GetGroupByName(name);
    }
    public Boolean CheckGroup(String name){
        if(repository.GetGroupByName(name) != null){
            return true;
        }
        return false;
    }
    public Groupe getGroupById(Long id){
         return repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Group does not exist"));
    }
    public void createGroup(Groupe group){
        repository.save(group);
            for (Candidat item:
                    group.getCandidats()) {
                candidatrepository.updatecandidatnewgroup(item.getId(),group.getId());
            }
    }
    public void removeGroup(Long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("the Group with the id " + id + " does not exist") ;
        }
        repository.deleteById(id);
    }
    public List<CustomGroup> GetGroupsCandidats(){
        List<Groupe> grouplist = repository.findAll();
        List<CustomGroup> customgroup = new ArrayList<>();
        for (Groupe item:grouplist) {
            customgroup.add(new CustomGroup(item,candidatrepository.getcandidatgroup(item.getId())));
        }
        return customgroup;
    }
    @Transactional
    public void updateGroup(Groupe gp){
         Groupe group= repository.findById(gp.getId())
                .orElseThrow(()->new IllegalStateException("Group does not exist"));
         if(gp.getNom() != null && gp.getNom().length() > 0){
             group.setNom(gp.getNom());
         }
        if(gp.getDescription() != null && gp.getDescription().length() > 0){
            group.setDescription(gp.getDescription());
        }
        List<Candidat> oldList = group.getCandidats();
        List<Candidat> newList = gp.getCandidats();
        List<Candidat> deletelist = oldList;
        List<Candidat> addList = oldList;
        for (Candidat item:
             oldList) {
            for (Candidat item2:
                 newList) {
                if(item.equals(item2)){
                    addList.remove(item2);
                    deletelist.remove(item);
                    break;
                }

            }
        }
        for (Candidat item:
             deletelist) {
            if(item.getGroupe().getId() == group.getId()){
                candidatrepository.updatecandidatgroup(item.getId());
            }
        }
        for (Candidat item:
                addList) {
            if(item.getGroupe().getId() == null){
                candidatrepository.updatecandidatnewgroup(item.getId(), group.getId());
            }
        }
    }

}


