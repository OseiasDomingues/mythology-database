package com.projectsdl.mythologydatabase.services.impl;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.repositories.GodRepository;
import com.projectsdl.mythologydatabase.services.GodService;
import com.projectsdl.mythologydatabase.services.exceptions.DatabaseException;
import com.projectsdl.mythologydatabase.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return godRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public GodModel save(GodModel godModel) {
        return godRepository.save(godModel);
    }

    @Override
    public void delete(Long id) {
        try{
        godRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public GodModel update(Long id, GodModel godNew) {
        GodModel godOld = godRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        return save(updateDate(godNew, godOld));
    }

    private GodModel updateDate(GodModel godNew, GodModel godOld) {
        godOld.setName(godNew.getName());
        godOld.setCulture(godNew.getCulture());
        godOld.setRole(godNew.getRole());
        godOld.setStory(godNew.getStory());
        godOld.setPantheon(godNew.getPantheon());
        return godOld;
    }
}
