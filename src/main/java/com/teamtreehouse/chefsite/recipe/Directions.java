package com.teamtreehouse.chefsite.recipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teamtreehouse.chefsite.core.BaseEntity;
import javax.persistence.Entity;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Directions extends BaseEntity{
    private String direction;

    public Directions(){
        super();
    }

    public Directions(String direction) {
        this();
        this.direction = direction;
    }

}


