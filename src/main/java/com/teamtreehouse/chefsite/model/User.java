package com.teamtreehouse.chefsite.model;

//The Person has a first name and a last name.
// There is also an id object that is configured to be
// automatically generated so you don’t have to deal with that

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamtreehouse.chefsite.core.BaseEntity;
import com.teamtreehouse.chefsite.recipe.Recipe;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.tomcat.jni.SSL.setPassword;
import static org.springframework.security.config.Elements.PASSWORD_ENCODER;

@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private long id;
    private String firstName;
    private String lastName;
    private String username;
//tells system to ignore
    @JsonIgnore
    private String password;
    @Column(nullable = false)
    private boolean enabled;
    @JsonIgnore
    private String[] roles;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Recipe> createdRecipe;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Recipe> favorites;

    public User() {
        super();
        createdRecipe = new ArrayList<>();
        favorites = new ArrayList<>();
    }

    public User (String username, String firstName, String password, String[] roles) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        setPassword(password);
        this.enabled = enabled;
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
    public void addCreatedRecipes (Recipe recipe) {
        createdRecipe.add(recipe);
    }

    public void removeCreatedRecipes (Recipe recipe) {
        createdRecipe.remove(recipe);
    }

    public List<Recipe> getCreatedRecipes () {
        return createdRecipe;
    }

    public void addFavorite(Recipe recipe) {
        favorites.add(recipe);
    }

    public void removeFavorite(Recipe recipe) {
        favorites.remove(recipe);
    }

    public List<Recipe> getFavorites() {
        return favorites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return username != null ? username.equals(user.username) : user.username == null;
    }
    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
// This repository is an interface and will allow you to perform
// various operations involving User objects. It gets these
// operations by extending the PagingAndSortingRepository
// interface defined in Spring Data Commons.
// At runtime, Spring Data REST will create an implementation
// of this interface automatically. Then it will use the
// @RepositoryRestResource annotation to direct Spring MVC to
// create RESTful endpoints at /people.

