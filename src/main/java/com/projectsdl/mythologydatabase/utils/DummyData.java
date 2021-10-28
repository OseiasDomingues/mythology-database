package com.projectsdl.mythologydatabase.utils;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.repositories.GodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DummyData {

    @Autowired
    GodRepository godRepository;

    @PostConstruct
    public void configTest(){

        GodModel god1 = new GodModel(null,"Zeus","Sky, Skies","He rules Olympus, the lofty cloudland where the Greek Gods live and look down upon mankind. He is a real high-flyer, an Olympic champion, battling with the giant Titans, casting thunderbolts and engaged in all manner of gut-busting glorious Godly pursuits");
        GodModel god2 = new GodModel(null,"Odin","Ruling","The Norse Biggy. Odin is King of Asgard, Ruler of the Aesir and the Lord of War, Death and Knowledge.");

        godRepository.saveAll(Arrays.asList(god1,god2));

    }
}
