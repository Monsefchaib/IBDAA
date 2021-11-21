package com.IBDAA.demo.Controllers;

import com.IBDAA.demo.Models.Formation;
import com.IBDAA.demo.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "api/v1/formation")
public class FormationController {
    private final FormationService service ;

    @Autowired
    public FormationController(FormationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Formation> getFormation(){
        return service.getFormation();
    }
    @PostMapping
    public void createFormation(@RequestBody Formation formation){
        service.createFormation(formation);
    }
    @DeleteMapping(path = "{formationId}")
    public void removeFormation(@PathVariable("formationId") Long id){
        service.removeFormation(id);
    }
    @PutMapping(path = "{formationId}")
    public void updateFormation(
            @PathVariable("formationId") Long formationId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer duration,
            @RequestParam(required = false) String desc,
            @RequestParam(required = false) String status
    ){
        service.updateFormation(formationId,name,type,duration,desc,status);
    }
    @GetMapping(path="/name/{name}")
    public Formation GetformationByName(@PathVariable("name") String name){
        return service.GetformationByName(name);
    }
    @GetMapping(path="/checkformation/{name}")
    public Boolean CheckFormation(@PathVariable("name") String name){
        return service.CheckFormation(name);
    }

}
