package com.projectsdl.mythologydatabase.services;

import com.projectsdl.mythologydatabase.models.GodModel;

public interface GodService {

    GodModel findAll();
    GodModel findById();
    GodModel save(Long id);
}
