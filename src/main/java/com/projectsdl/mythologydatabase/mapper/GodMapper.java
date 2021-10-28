package com.projectsdl.mythologydatabase.mapper;

import com.projectsdl.mythologydatabase.dto.GodDTO;
import com.projectsdl.mythologydatabase.models.GodModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GodMapper {

    GodMapper INSTANCE = Mappers.getMapper(GodMapper.class);

    GodModel toModel(GodDTO godDTO);

    GodDTO toDTO(GodModel godModel);
}
