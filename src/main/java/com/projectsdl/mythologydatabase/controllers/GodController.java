package com.projectsdl.mythologydatabase.controllers;

import com.projectsdl.mythologydatabase.dto.GodDTO;
import com.projectsdl.mythologydatabase.mapper.GodMapper;
import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.services.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gods")
public class GodController {

    @Autowired
    GodService godService;

    private final GodMapper godMapper = GodMapper.INSTANCE;


    @GetMapping
    public ResponseEntity<List<GodDTO>> findAll(){

        List<GodModel> godList = godService.findAll();

        if(godList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            List<GodDTO> godDTOList= godList
                    .stream()
                    .map(x -> godMapper.toDTO(x))
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(godDTOList);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<GodDTO> findById(@PathVariable Long id){
        GodModel objGodModel = godService.findById(id);
        GodDTO objDTO = godMapper.toDTO(objGodModel);
        return ResponseEntity.status(HttpStatus.OK).body(objDTO);
    }
    @PostMapping
    public ResponseEntity<GodModel> save(@RequestBody GodDTO godDTO){
        GodModel newGod = godMapper.toModel(godDTO);
        godService.save(newGod);
        return ResponseEntity.status(HttpStatus.OK).body(newGod);
    }

}
