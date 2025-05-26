package com.github.chelovekkrokant.foodordering.util;

import com.github.chelovekkrokant.foodordering.shawarma.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(){
        ingredientMap.put("COLA", new Ingredient("COLA", "Corn lavash", Ingredient.Type.WRAP));
        ingredientMap.put("WHLA", new Ingredient("WHLA", "Wheat lavash", Ingredient.Type.WRAP));
        ingredientMap.put("CHLA", new Ingredient("CHLA", "Cheese lavash", Ingredient.Type.WRAP));
        ingredientMap.put("CHIC", new Ingredient("CHIC", "Chicken meat", Ingredient.Type.MEAT));
        ingredientMap.put("BEEF", new Ingredient("BEEF", "Beeg meat", Ingredient.Type.MEAT));
        ingredientMap.put("FALA", new Ingredient("FALA", "No meat, just falafel", Ingredient.Type.MEAT));
        ingredientMap.put("TOMA", new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGETABLE));
        ingredientMap.put("CUCU", new Ingredient("CUCU", "Cucumber", Ingredient.Type.VEGETABLE));
        ingredientMap.put("CHCA", new Ingredient("CHCA", "Chinese cabbage", Ingredient.Type.VEGETABLE));
        ingredientMap.put("GARL", new Ingredient("GARL", "Garlic sauce", Ingredient.Type.SAUCE));
        ingredientMap.put("KETC", new Ingredient("KETC", "Ketchup", Ingredient.Type.SAUCE));
        ingredientMap.put("SOUR", new Ingredient("SOUR", "Sour cream", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
