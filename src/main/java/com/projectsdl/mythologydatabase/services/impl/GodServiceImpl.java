package com.projectsdl.mythologydatabase.services.impl;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.repositories.GodRepository;
import com.projectsdl.mythologydatabase.services.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GodServiceImpl implements GodService {

    @Autowired
    GodRepository godRepository;

    @Override
    public List<GodModel> findAll() {
        return godRepository.findAll();
    }

    @Override
    public GodModel findById(Long id) {
        return godRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public GodModel save(GodModel godModel) {
        return godRepository.save(godModel);
    }
}
