package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Models.Utilisateur;
import com.IBDAA.demo.Repositorys.CandidatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CandidatService {
    private final CandidatRepository repository;


    public CandidatService(CandidatRepository repository) {
        this.repository = repository;
    }
    public List<Candidat> getCandidats(){
        return repository.findAll();
    }
    public void createCandidat(Candidat candidat){
        repository.save(candidat);
    }
    public void removeCandidat(long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("No Candidate with the id : "+id+"exist!");
        }
        repository.deleteById(id);
    }
    public void updateCandidate(Long id, String type, Groupe groupId){
        Candidat candidat = repository.findById(id)
                .orElseThrow(()->new IllegalStateException("no Candidate found !!"));
        if(type != null && type.length()>0 && !Objects.equals(candidat.getNom(),type)){
            candidat.setNom(type);
        }
        if(groupId != null && !Objects.equals(candidat.getGroupe(),groupId)){
            candidat.setGroupe(groupId);
        }
    }
    public void updatecandidategroup(Long id){
        repository.updatecandidatgroup(id);
    }
    public List<Candidat> getcandidatgroup(Long groupid){
        return repository.getcandidatgroup(groupid);
    }
    public List<Candidat> getCadidatByName(String name){return repository.getCadidatByName(name);}
}
