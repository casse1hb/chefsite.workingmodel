package com.teamtreehouse.chefsite.core;

import com.teamtreehouse.chefsite.recipe.Category;
import com.teamtreehouse.chefsite.recipe.Recipe;
import com.teamtreehouse.chefsite.repositories.RecipeRepository;
import com.teamtreehouse.chefsite.repositories.UserRepository;
import com.teamtreehouse.chefsite.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

//TODO: add db loader. templates? buzzwords?
//TODO: why wont users load right?
@Component
public class DataBaseLoader implements ApplicationRunner {
    private final RecipeRepository recipes;
    private final UserRepository users;
    private CategoryServiceImpl categoryService;

    @Autowired
    public DataBaseLoader(RecipeRepository recipes, UserRepository users) {
        this.recipes = recipes;
        this.users = users;
    }


//should let only certain users edit their "favorited" recipe
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Recipe recipe = new Recipe("Cooking", "https://google.com");
        recipe.addIngredient(new Recipe());
        recipes.save(recipe);

        String[] categories = {
                "Breakfast",
                "Brunch",
                "Lunch",
                "Dinner",
                "Snack",
        };
        List<Category> categoryList = new ArrayList<>();
        IntStream.range(0, 5)
                .forEach(i -> {
                    Locale.Category c = new Locale.Category();
                    recipe.setName();
                    categoryService.save(c)
                });

        String[] recipeNames = {
                "Popsicles",
                "Mac and Cheese",
                "Sandwich",
                "Salad",
                "Potato Soup"
        };
        String[] measurements = {
                "1 cup",
                "2 tablespoons",
                "1 teaspoon",
                "1/2 cup",
                "1/4 cup"
        };
        String[] ingredients = {
                "Carrots",
                "Potatos",
                "Lettuce",
                "Bell Pepper",
                "Rice",
                "Black Beans",
                "Pinto Beans",
                "Chic Peas",
                "Apples",
                "Lettuce",
        };

        String[] directions = {
                "Heat skillet",
                "Add small ammount oil to pan",
                "Place deshelled eggs into pan",
                "Place sausage in skillet",
                "cook both until sausage is completely browned and cooked, eggs cook until egg no longer has clear fluid"
        };

        List<Recipe> recipes = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach((int i) -> {
                    Recipe r = new Recipe();
                    r.setCategory(categoryList.get(i));
                    String ingredient = ingredients[i];
                    String direction = directions[i % directions.length];
                    String category = categories[i % categories.length];
                    Category c = new Category();
                    c.setName(String.format());
                });


    }