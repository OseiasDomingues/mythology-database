package com.projectsdl.mythologydatabase.repositories;

import com.projectsdl.mythologydatabase.models.GodModel;
import com.projectsdl.mythologydatabase.models.PantheonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantheonRepository extends JpaRepository<PantheonModel, Long> {
}
