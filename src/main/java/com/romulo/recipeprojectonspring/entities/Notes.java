package com.romulo.recipeprojectonspring.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(exclude="recipe")
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

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
