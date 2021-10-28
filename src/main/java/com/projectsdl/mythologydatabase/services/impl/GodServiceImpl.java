package com.projectsdl.mythologydatabase.services.impl;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.repositories.GodRepository;
import com.projectsdl.mythologydatabase.services.GodService;
import com.projectsdl.mythologydatabase.services.exceptions.ObjectNotFound;
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
        return godRepository.findById(id).orElseThrow(() -> new ObjectNotFound(id));
    }

    @Override
    public GodModel save(GodModel godModel) {
        return godRepository.save(godModel);
    }

    @Override
    public void delete(Long id) {
        godRepository.deleteById(id);
    }

    @Override
    public GodModel update(Long id, GodModel godNew) {
        GodModel godOld = godRepository.getById(id);
        if (godOld == null) {
            return null;
        }
        return save(updateDate(godNew, godOld));
    }

    private GodModel updateDate(GodModel godNew, GodModel godOld) {
        godOld.setName(godNew.getName());
        godOld.setExpertise(godNew.getExpertise());
        godOld.setStory(godNew.getStory());
        return godOld;
    }
}
