package com.IBDAA.demo.Controllers;

import com.IBDAA.demo.Models.Utilisateur;
import com.IBDAA.demo.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path="api/v1/utilisateur")
public class UtilisateurController {
    private final UtilisateurService service;

    @Autowired
    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Utilisateur> getUtilisateur(){
        return service.getUtilisateur();
    }
    @PostMapping
    public void createUtilisateur(@RequestBody Utilisateur utilisateur){
        service.createUtilisateur(utilisateur);
    }
    @DeleteMapping(path="{id}")
    public void removeUtilisateur(@PathVariable("id") Long id){
        service.removeUtilisateur(id);
    }
    @PutMapping(path="{id}")
    public void updateUtilisateur(
            @PathVariable("formationId") Long id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String cin,
            @RequestParam(required = false) String telephone,
            @RequestParam(required = false) String adresse
    ){
        service.updateUtilisateur(id,nom,prenom,email,cin,telephone,adresse);
    }


}
