package com.IBDAA.demo.Controllers;


import com.IBDAA.demo.Models.Formateur;
import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Models.Sceance;
import com.IBDAA.demo.Services.SceanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sceance")
public class SceanceController {
    private final SceanceService service;

    @Autowired
    public SceanceController(SceanceService service){this.service = service;}

    @GetMapping
    public List<Sceance> getSceance(){return service.getSceances();}
    @PostMapping
    public void createSceance(@RequestBody Sceance sceance){service.createSceance(sceance);}
    @GetMapping(path = "{id}")
    public Sceance getSceanceById(@PathVariable("id") Long id){
        return service.getSceanceById(id);
    }
    @DeleteMapping(path="{id}")
    public void removeSceance(@PathVariable("id") Long id){service.removeSceance(id);}
    @PutMapping(path="{id}")
    public  void updateSceance(@PathVariable("id") Long id,
                               @RequestParam(required = false) String nom,
                               @RequestParam(required = false) LocalDateTime dateTimeDebut,
                               @RequestParam(required = false) LocalDateTime dateTimeFin,
                               @RequestParam(required = false) Formateur formateur,
                               @RequestParam(required = false) Formation formation,
                               @RequestParam(required = false) Groupe groupe
    ){
        service.updateSceance(id,nom,dateTimeDebut,dateTimeFin,formateur,formation,groupe);
    }
}
