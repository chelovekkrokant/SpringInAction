package com.github.chelovekkrokant.foodordering.util;

import com.github.chelovekkrokant.foodordering.shawarma.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import com.github.chelovekkrokant.foodordering.shawarma.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(){
        ingredientMap.put("COLA", new Ingredient("COLA", "Corn lavash", Type.WRAP));
        ingredientMap.put("WHLA", new Ingredient("WHLA", "Wheat lavash", Type.WRAP));
        ingredientMap.put("CHLA", new Ingredient("CHLA", "Cheese lavash", Type.WRAP));
        ingredientMap.put("CHIC", new Ingredient("CHIC", "Chicken meat", Type.MEAT));
        ingredientMap.put("BEEF", new Ingredient("BEEF", "Beeg meat", Type.MEAT));
        ingredientMap.put("FALA", new Ingredient("FALA", "No meat, just falafel", Type.MEAT));
        ingredientMap.put("TOMA", new Ingredient("TOMA", "Tomato", Type.VEGETABLE));
        ingredientMap.put("CUCU", new Ingredient("CUCU", "Cucumber", Type.VEGETABLE));
        ingredientMap.put("CHCA", new Ingredient("CHCA", "Chinese cabbage", Type.VEGETABLE));
        ingredientMap.put("GARL", new Ingredient("GARL", "Garlic sauce", Type.SAUCE));
        ingredientMap.put("KETC", new Ingredient("KETC", "Ketchup", Type.SAUCE));
        ingredientMap.put("SOUR", new Ingredient("SOUR", "Sour cream", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
