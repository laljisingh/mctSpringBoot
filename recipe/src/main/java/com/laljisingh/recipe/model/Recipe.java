package com.laljisingh.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipe_id;
    @NotBlank(message = "recipe name not blank")
    @NotNull(message = "recipe name not null")
    private String recipe_name;
    @NotBlank(message = "ingredients name not blank")
    @NotNull(message = "ingredients name not null")
    private String ingredients;
    @NotBlank(message = "instruction name not blank")
    @NotNull(message = "instruction name not null")
    private String instruction;

    @ManyToOne
    private User user_id;
}
