package com.spring.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Murtaza on 2/7/2019.
 */
public class Category {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
