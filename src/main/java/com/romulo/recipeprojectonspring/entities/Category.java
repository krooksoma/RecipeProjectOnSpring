package com.romulo.recipeprojectonspring.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

//    name of the field is used as reference on mappedBy
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
