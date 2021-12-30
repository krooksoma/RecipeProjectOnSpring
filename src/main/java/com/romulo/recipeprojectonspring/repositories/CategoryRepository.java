package com.romulo.recipeprojectonspring.repositories;

import com.romulo.recipeprojectonspring.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    //optional makes spring return the optional type
    Optional<Category> findByDescription(String description);
}
