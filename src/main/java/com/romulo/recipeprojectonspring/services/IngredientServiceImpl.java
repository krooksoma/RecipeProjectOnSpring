package com.romulo.recipeprojectonspring.services;

import com.romulo.recipeprojectonspring.entities.Ingredient;
import com.romulo.recipeprojectonspring.entities.Recipe;
import com.romulo.recipeprojectonspring.commands.IngredientCommand;
import com.romulo.recipeprojectonspring.repositories.RecipeRepository;
import com.romulo.recipeprojectonspring.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void deleteById(Long recipeId, Long idToDelete) {
        log.debug("Deleting ingredient: " + recipeId + " : " + idToDelete);

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            log.debug("Recipe Found!");

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(idToDelete))
                    .findFirst();
            if (ingredientOptional.isPresent()) {
                log.debug("Found Ingredient");
                Ingredient ingredientToDelete = ingredientOptional.get();
                ingredientToDelete.setRecipe(null);
                recipe.getIngredients().remove(ingredientOptional.get());
                recipeRepository.save(recipe);
            }
        }else {
            log.debug("Recipe Id not Found. Id: " + recipeId);

        }
    }
}
