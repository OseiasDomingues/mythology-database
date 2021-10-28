package com.projectsdl.mythologydatabase.services.impl;

import com.projectsdl.mythologydatabase.models.PantheonModel;
import com.projectsdl.mythologydatabase.repositories.PantheonRepository;
import com.projectsdl.mythologydatabase.services.PantheonService;
import com.projectsdl.mythologydatabase.services.exceptions.DatabaseException;
import com.projectsdl.mythologydatabase.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantheonServiceImpl implements PantheonService {

    @Autowired
    PantheonRepository pantheonRepository;

    @Override
    public List<PantheonModel> findAll() {
        return pantheonRepository.findAll();
    }

    @Override
    public PantheonModel findById(Long id) {
        return pantheonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public PantheonModel save(PantheonModel pantheonModel) {
        return pantheonRepository.save(pantheonModel);
    }

   
}
