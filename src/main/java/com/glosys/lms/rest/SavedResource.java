package com.glosys.lms.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SavedResource {
    private int id;
    @JsonCreator
    public SavedResource(@JsonProperty("id") int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
