package com.teamtreehouse.chefsite.dao;

import com.teamtreehouse.chefsite.recipe.Directions;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DirectionsDao  extends PagingAndSortingRepository<Directions, Long> {
    Directions findOne(Long id);
}

