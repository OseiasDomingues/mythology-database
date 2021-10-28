package com.projectsdl.mythologydatabase.controllers;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.services.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gods")
public class GodController {

    @Autowired
    GodService godService;

    @GetMapping
    public ResponseEntity<List<GodModel>> findAll(){
        List<GodModel> godList = godService.findAll();
        if(godList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(godList);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<GodModel> findById(@PathVariable Long id){
        GodModel objGodModel = godService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(objGodModel);
    }
    @PostMapping
    public ResponseEntity<GodModel> save(@RequestBody GodModel godModel){
        GodModel entityGodModel = godService.save(godModel);
        return ResponseEntity.status(HttpStatus.OK).body(entityGodModel);
    }

}
