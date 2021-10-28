package com.projectsdl.mythologydatabase.utils;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.models.PantheonModel;
import com.projectsdl.mythologydatabase.repositories.GodRepository;
import com.projectsdl.mythologydatabase.repositories.PantheonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DummyData {

    @Autowired
    GodRepository godRepository;
    @Autowired
    PantheonRepository pantheonRepository;

    @PostConstruct
    public void configTest(){

        PantheonModel p1 = new PantheonModel(null, "Gods of Norse","Uppsala");
        PantheonModel p2 = new PantheonModel(null, "Gods of Greek","Partenon");

        pantheonRepository.saveAll(Arrays.asList(p1,p2));

        GodModel god1 = new GodModel(null,"Zeus","Sky, Skies","greek",
                "He rules Olympus, the lofty cloudland where the Greek Gods live and look down upon mankind. He is a real high-flyer, an Olympic champion, battling with the giant Titans, casting thunderbolts and engaged in all manner of gut-busting glorious Godly pursuits"
                ,p2);
        GodModel god2 = new GodModel(null,"Odin","Ruling","nordic",
                "The Norse Biggy. Odin is King of Asgard, Ruler of the Aesir and the Lord of War, Death and Knowledge."
                ,p1);GodModel god3 = new GodModel(null,"Hades","Hell","greek",
                "He’s the son of Cronus and Rhea. When the family fortune was divvied up, he got the Underworld share while his brothers Zeus and Poseidon were given the Sky and Sea. There’s nothing wrong with nepotism as long as you keep it in the family. They even named the place after him."
                ,p2);

        godRepository.saveAll(Arrays.asList(god1,god2,god3));

    }
}
