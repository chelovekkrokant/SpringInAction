package com.github.chelovekkrokant.foodordering.controller;

import com.github.chelovekkrokant.foodordering.shawarma.Ingredient;
import com.github.chelovekkrokant.foodordering.shawarma.Order;
import com.github.chelovekkrokant.foodordering.shawarma.Packaging;
import com.github.chelovekkrokant.foodordering.shawarma.Shawarma;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignShawarmaController {
    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("COLA", "Corn lavash", Ingredient.Type.WRAP),
                new Ingredient("WHLA", "Wheat lavash", Ingredient.Type.WRAP),
                new Ingredient("CHLA", "Cheese lavash", Ingredient.Type.WRAP),
                new Ingredient("CHIC", "Chicken meat", Ingredient.Type.MEAT),
                new Ingredient("BEEF", "Beeg meat", Ingredient.Type.MEAT),
                new Ingredient("FALA", "No meat, just falafel", Ingredient.Type.MEAT),
                new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGETABLE),
                new Ingredient("CUCU", "Cucumber", Ingredient.Type.VEGETABLE),
                new Ingredient("CHCA", "Chinese cabbage", Ingredient.Type.VEGETABLE),
                new Ingredient("GARL", "Garlic sauce", Ingredient.Type.SAUCE),
                new Ingredient("KETC", "Ketchup", Ingredient.Type.SAUCE),
                new Ingredient("SOUR", "Sour cream", Ingredient.Type.SAUCE)
        );

        List<Packaging> packagings = Arrays.asList(
                new Packaging("GOCH", "Go, cheep", Packaging.Purpose.GO),
                new Packaging("GOTH", "Go, thermo", Packaging.Purpose.GO),
                new Packaging("INCH", "In, cheep", Packaging.Purpose.IN),
                new Packaging("INTH", "In, thermo", Packaging.Purpose.IN)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "shawarma")
    public Shawarma shawarma(){
        return new Shawarma();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processShawarma(Shawarma shawarma, @ModelAttribute Order order){
        order.addShawarma(shawarma);
        log.info("Processing shawarma: {}", shawarma);
        
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
