package com.teamtreehouse.chefsite.recipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teamtreehouse.chefsite.core.BaseEntity;
import com.teamtreehouse.chefsite.core.BaseEntity;
import com.teamtreehouse.chefsite.model.User;
import com.teamtreehouse.chefsite.recipe.Recipe;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe extends BaseEntity {
    @NotNull(message = "Recipe name must not be blank")
    @Size(max = 40)
    private String name;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;
    @OneToMany
    private List<Ingredient> ingredients;
    @OneToMany
    private List<Directions> direction;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Recipe() {
        super();
        ingredients = new ArrayList<>();
        direction = new ArrayList<>();
    }

    public Recipe(String name, Category category,
                  String imageUrl, List<Ingredient> ingredients, List<Directions> directions,
                  User user) {
        this();
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.direction = direction;
        this.user = user;
    }

    public void addIngredient(Recipe ingredient) {
        ingredients.add(ingredient);
    }

    public void addDirection(Directions directions) {
        direction.add(directions);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Directions> getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFavorited(User user) {
        return user.getFavorites().contains(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        return user != null ? user.equals(recipe.user) : recipe.user == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

}
