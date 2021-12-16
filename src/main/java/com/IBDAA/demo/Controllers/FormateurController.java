package com.IBDAA.demo.Controllers;



import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Formateur;
import com.IBDAA.demo.Services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path="api/v1/formateur")
public class FormateurController {

    private final FormateurService service;

    @Autowired
    public FormateurController(FormateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Formateur> getFormateur(){return service.getFormateur();}
    @GetMapping(path = "/id/{formateurId}")
    public Formateur getFormateurById(@PathVariable Long id){return service.getFormateurById(id);}
    @PostMapping
    public void createFormateur(@RequestBody Formateur f){
         service.createFormateur(f);
    }
}
