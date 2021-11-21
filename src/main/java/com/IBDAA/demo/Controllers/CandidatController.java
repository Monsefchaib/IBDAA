package com.IBDAA.demo.Controllers;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path="api/v1/candidat")
public class CandidatController {
    private final CandidatService service;
    @Autowired
    public CandidatController(CandidatService service) {
        this.service = service;
    }
    @GetMapping
    public List<Candidat> getCandidats(){return service.getCandidats();}
    @GetMapping(path = "/name/{name}")
    public List<Candidat> getCadidatByName(@PathVariable("name") String name){return service.getCadidatByName(name);}
    @PostMapping
    public void createCandidat(@RequestBody Candidat candidat){service.createCandidat(candidat);}
    @DeleteMapping(path="{id}")
    public void deleteCandidat(@PathVariable("id") Long id){
        service.removeCandidat(id);
    }
    @PutMapping(path = "{id}")
    public void updateCandidat(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Groupe groupid
            )
    {
        service.updateCandidate(id,type,groupid);
    }



}
