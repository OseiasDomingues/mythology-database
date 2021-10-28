package com.projectsdl.mythologydatabase.dto;

import com.projectsdl.mythologydatabase.models.PantheonModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class GodDTO implements Serializable {

    private static final long serialVersionUID = 50585560893586437L;

    private String name;
    private String role;
    private String culture;
    private String story;
    private PantheonModel pantheon;

}
