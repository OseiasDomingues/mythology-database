package com.projectsdl.mythologydatabase.repositories;

import com.projectsdl.mythologydatabase.models.GodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GodRepository extends JpaRepository<GodModel, Long> {
}
