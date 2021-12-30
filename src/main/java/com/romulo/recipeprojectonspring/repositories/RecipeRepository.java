package com.romulo.recipeprojectonspring.repositories;

import com.romulo.recipeprojectonspring.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
