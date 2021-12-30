package com.romulo.recipeprojectonspring.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //  cascades specification is not necessary. This way recipe "own" this entity
    // this allows to delete a note without deleting a recipe object

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
