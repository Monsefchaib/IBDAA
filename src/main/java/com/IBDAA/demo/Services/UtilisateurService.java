package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Utilisateur;
import com.IBDAA.demo.Repositorys.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UtilisateurService {
    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }
    public List<Utilisateur> getUtilisateur(){
        return repository.findAll();
    }
    public void createUtilisateur(Utilisateur utilisateur){
        repository.save(utilisateur);
    }
    public void removeUtilisateur(long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("No User with the id : "+id+"exist!");
        }
        repository.deleteById(id);
    }
    public void updateUtilisateur(long id,String nom,String prenom,String email,String cin,String telephone,String adresse){
        Utilisateur utilisateur = repository.findById(id)
                .orElseThrow(()->new IllegalStateException("No user found"));
        if(nom != null && nom.length()>0 && !Objects.equals(utilisateur.getNom(),nom)){
            utilisateur.setNom(nom);
        }
        if(prenom != null && prenom.length()>0 && !Objects.equals(utilisateur.getPrenom(),prenom)){
            utilisateur.setPrenom(prenom);
        }
        if(email != null && email.length()>0 && !Objects.equals(utilisateur.getEmail(),email)){
            utilisateur.setEmail(email);
        }
        if(cin != null && cin.length()>0 && !Objects.equals(utilisateur.getCin(),cin)){
            utilisateur.setCin(cin);
        }
        if(telephone != null && telephone.length()>0 && !Objects.equals(utilisateur.getTelephone(),telephone)){
            utilisateur.setTelephone(telephone);
        }
        if(adresse != null && adresse.length()>0 && !Objects.equals(utilisateur.getAdresse(),adresse)){
            utilisateur.setAdresse(adresse);
        }

    }
}
