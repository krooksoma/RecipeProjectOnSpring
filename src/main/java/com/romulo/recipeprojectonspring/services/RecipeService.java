package com.romulo.recipeprojectonspring.services;

import com.romulo.recipeprojectonspring.commands.RecipeCommand;
import com.romulo.recipeprojectonspring.entities.Recipe;
import javassist.NotFoundException;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l) throws NotFoundException;

    void deleteById(Long idToDelete);
}
