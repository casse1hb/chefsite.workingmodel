package com.teamtreehouse.chefsite.dao;

import com.teamtreehouse.chefsite.recipe.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryDao extends PagingAndSortingRepository<Category, Long> {
    Category findOne(Long id);
}
