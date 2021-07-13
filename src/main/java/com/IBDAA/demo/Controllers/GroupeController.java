package com.IBDAA.demo.Controllers;

import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
@RestController
@RequestMapping(path="api/v1/group")
public class GroupeController {
    private final GroupeService service;

    @Autowired
    public GroupeController(GroupeService service) {
        this.service = service;
    }
    @GetMapping
    public List<Groupe> getGroups(){
        return service.getGroups();
    }
    @GetMapping(path = "{groupId}")
    public Groupe getGroupById(@PathVariable("groupId") Long id){
        return service.getGroupById(id);
    }
    @PostMapping
    public void createGroup(Groupe group){
        service.createGroup(group);
    }
    @DeleteMapping(path = "{groupId}")
    public void removeGroup(@PathVariable("groupId") Long id){
        service.removeGroup(id);
    }
    @PutMapping()
    public void  updateGroup(@RequestBody() Groupe group){
        service.updateGroup(group);
    }
}
