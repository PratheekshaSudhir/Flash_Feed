package com.example.newme.Models;

import java.io.Serializable;

public class Source implements Serializable {
//    source has got 2 objects in api i.e id and name so we create 2 objects here and create getter and setter methods.
    String id = "";
    String name = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
