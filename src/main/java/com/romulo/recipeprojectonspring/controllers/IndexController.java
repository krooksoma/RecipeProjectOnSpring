package com.romulo.recipeprojectonspring.controllers;


import com.romulo.recipeprojectonspring.entities.Category;
import com.romulo.recipeprojectonspring.entities.UnitOfMeasure;
import com.romulo.recipeprojectonspring.repositories.CategoryRepository;
import com.romulo.recipeprojectonspring.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({" ", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Tablespoon");

        categoryOptional.ifPresent(catOptional -> System.out.println("Cat id is: " + catOptional.getId()));

        unitOfMeasure.ifPresent(ofMeasure -> System.out.println("Uom id id: " + ofMeasure.getId()));
        return "index";
    }
}
