package com.projectsdl.mythologydatabase.controllers;

import com.projectsdl.mythologydatabase.dto.GodDTO;
import com.projectsdl.mythologydatabase.mapper.GodMapper;
import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.models.PantheonModel;
import com.projectsdl.mythologydatabase.services.GodService;
import com.projectsdl.mythologydatabase.services.PantheonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pantheons")
@Api
public class PantheonController {

    @Autowired
    PantheonService pantheonService;


    @GetMapping
    @ApiOperation("Searches all pantheons from the database")
    public ResponseEntity<List<PantheonModel>> findAll() {

        List<PantheonModel> pantheonModelList = pantheonService.findAll();

        if (pantheonModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(pantheonModelList);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Searches for a specific pantheon from the database")
    public ResponseEntity<PantheonModel> findById(@PathVariable Long id) {
        PantheonModel pantheonModel = pantheonService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pantheonModel);
    }

    @PostMapping
    @ApiOperation("Insert a new pantheon into the database")
    public ResponseEntity<PantheonModel> save(@RequestBody PantheonModel pantheonModel) {
        PantheonModel newPantheon = pantheonService.save(pantheonModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPantheon);
    }


}
