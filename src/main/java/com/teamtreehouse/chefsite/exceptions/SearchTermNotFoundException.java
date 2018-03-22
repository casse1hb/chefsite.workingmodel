package com.teamtreehouse.chefsite.exceptions;

public class SearchTermNotFoundException extends RuntimeException {
    public SearchTermNotFoundException() {
        super("Sorry, no recipes found. Please try again.");
    }
}
