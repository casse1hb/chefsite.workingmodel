package com.teamtreehouse.chefsite.repositories;

import com.teamtreehouse.chefsite.model.User;
import com.teamtreehouse.chefsite.recipe.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface RecipeRepository extends PagingAndSortingRepository<User, Long> {

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Recipe> findByTitleContaining(@Param("title") String title, Pageable page);

}
