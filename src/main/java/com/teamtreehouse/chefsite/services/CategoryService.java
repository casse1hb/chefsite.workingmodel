package com.teamtreehouse.chefsite.services;

import com.teamtreehouse.chefsite.recipe.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Category category);
}
