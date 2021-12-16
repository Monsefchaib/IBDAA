package com.IBDAA.demo.Controllers;

import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Services.GroupeService;
import com.IBDAA.demo.Type.CustomGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping(path="api/v1/group")
public class GroupeController {
    private final GroupeService service;

    @Autowired
    public GroupeController(GroupeService service) {
        this.service = service;
    }
    @GetMapping
    public List<Groupe> getGroups(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description){
        return service.getGroups(name,description);

    }
    @GetMapping(path="/name/{name}")
    public Groupe GetGroupByName(@PathVariable("name") String name){return  service.GetGroupByName(name);}
    @GetMapping(path = "/id/{groupId}")
    public Groupe getGroupById(@PathVariable("groupId") Long id){
        return service.getGroupById(id);
    }
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void createGroup(@RequestBody Groupe group){
        service.createGroup(group);
    }
    @DeleteMapping()
    public void removeGroup(@RequestBody() Groupe group){
        service.removeGroup(group);
    }
    //@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void  updateGroup(@RequestBody() Groupe group){
        service.updateGroup(group);
    }
    @GetMapping(path="/getgroups")
    public List<CustomGroup> GetGroupsCandidats(){return service.GetGroupsCandidats();}
    @GetMapping(path="/checkgroup/{groupname}")
    public Boolean CheckGroup(@PathVariable("groupname") String name){return service.CheckGroup(name);}
}
