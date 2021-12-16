package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Formateur;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Repositorys.FormateurRepository;
import com.IBDAA.demo.Repositorys.SceanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {

    private final FormateurRepository repository;

    @Autowired
    public FormateurService(FormateurRepository repository) {this.repository = repository ;}
    public List<Formateur> getFormateur(){
        return repository.findAll();
    }
    public void createFormateur(Formateur formateur){
        repository.save(formateur);
    }
    public Formateur getFormateurById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Formateur does not exist"));
    }
}
