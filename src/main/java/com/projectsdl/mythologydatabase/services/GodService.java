package com.projectsdl.mythologydatabase.services;

import com.projectsdl.mythologydatabase.models.GodModel;

import java.util.List;

public interface GodService {

    List<GodModel> findAll();
    GodModel findById(Long id);
    GodModel save(GodModel godModel);
}
