package com.teamtreehouse.chefsite.services;

import com.teamtreehouse.chefsite.recipe.Directions;

import java.util.List;

public interface DirectionsService {
    List<Directions> findAll();
    Directions findById(Long id);
    void save(Directions directions);
    void delete(Directions directions);
}
