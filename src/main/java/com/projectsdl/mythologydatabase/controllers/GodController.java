package com.projectsdl.mythologydatabase.controllers;

import com.projectsdl.mythologydatabase.dto.GodDTO;
import com.projectsdl.mythologydatabase.mapper.GodMapper;
import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.services.GodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gods")
@Api
public class GodController {

    @Autowired
    GodService godService;

    private final GodMapper godMapper = GodMapper.INSTANCE;


    @GetMapping
    @ApiOperation("Searches all gods and goddesses from the database")
    public ResponseEntity<List<GodDTO>> findAll() {

        List<GodModel> godList = godService.findAll();

        if (godList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            List<GodDTO> godDTOList = godList
                    .stream()
                    .map(x -> godMapper.toDTO(x))
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(godDTOList);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Searches for a specific gods or goddesses from the database")
    public ResponseEntity<GodDTO> findById(@PathVariable Long id) {
        GodModel objGodModel = godService.findById(id);
        GodDTO objDTO = godMapper.toDTO(objGodModel);
        return ResponseEntity.status(HttpStatus.OK).body(objDTO);
    }

    @PostMapping
    @ApiOperation("Insert a new god or goddess into the database")
    public ResponseEntity<GodModel> save(@RequestBody GodDTO godDTO) {
        GodModel newGod = godMapper.toModel(godDTO);
        godService.save(newGod);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGod);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a god or goddess from the database")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        godService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    @ApiOperation("Update a god or goddess from the database")
    public ResponseEntity<GodModel> update(@PathVariable Long id, @RequestBody GodDTO godDTO){
        GodModel godModel = godMapper.toModel(godDTO);
        GodModel godUpdate = godService.update(id, godModel);
        return ResponseEntity.status(HttpStatus.OK).body(godUpdate);
    }

}
