package com.romulo.recipeprojectonspring.controllers;


import com.romulo.recipeprojectonspring.entities.Category;
import com.romulo.recipeprojectonspring.entities.UnitOfMeasure;
import com.romulo.recipeprojectonspring.repositories.CategoryRepository;
import com.romulo.recipeprojectonspring.repositories.UnitOfMeasureRepository;
import com.romulo.recipeprojectonspring.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @RequestMapping({" ", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Getting index Page");

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
