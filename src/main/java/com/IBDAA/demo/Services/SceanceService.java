package com.IBDAA.demo.Services;

import com.IBDAA.demo.Models.Formateur;
import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Models.Sceance;
import com.IBDAA.demo.Repositorys.SceanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class SceanceService {
    private final SceanceRepository repository;

    @Autowired
    public SceanceService(SceanceRepository repository) {this.repository = repository ;}

    public List<Sceance> getSceances() { return repository.findAll();}
    public void createSceance(Sceance sceance) {repository.save(sceance);}
    public Sceance getSceanceById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Seance does not exist"));
    }
    public void removeSceance (Long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("La Sceance n'existe pas");
        }
        repository.deleteById(id);
    }
    @Transactional
    public void updateSceance(Long id, String nom, LocalDateTime dateTimeDebut, LocalDateTime dateTimeFin, Formateur sceanceFormateur, Formation formation, Groupe groupe) {
        Sceance sceance = repository.findById(id).orElseThrow(() -> new IllegalStateException("Sceance n'existe pas"));
    }
}
