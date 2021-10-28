package com.projectsdl.mythologydatabase.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GodDTO implements Serializable {

    private static final long serialVersionUID = 50585560893586437L;

    private String name;
    private String expertise;
    private String story;

}
