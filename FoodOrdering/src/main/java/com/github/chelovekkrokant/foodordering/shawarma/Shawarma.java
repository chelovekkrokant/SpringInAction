package com.github.chelovekkrokant.foodordering.shawarma;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Shawarma {
    @NotNull
    @Size(min=3, message = "Length should be at least 5")
    private String name;

    @NotNull
    @Size(min=1, message = "Add at least one ingredient")
    private List<Ingredient> ingredients;

}
