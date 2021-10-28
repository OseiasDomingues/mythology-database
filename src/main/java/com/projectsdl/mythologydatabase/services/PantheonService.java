package com.projectsdl.mythologydatabase.services;

import com.projectsdl.mythologydatabase.models.PantheonModel;

import java.util.List;

public interface PantheonService {

    List<PantheonModel> findAll();
    PantheonModel findById(Long id);
    PantheonModel save(PantheonModel pantheonModel);
}
