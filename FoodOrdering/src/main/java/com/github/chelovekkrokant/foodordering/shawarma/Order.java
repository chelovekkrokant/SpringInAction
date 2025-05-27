package com.github.chelovekkrokant.foodordering.shawarma;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    @NotBlank(message = "Please, enter the name")
    private String deliveryName;

    @NotBlank(message = "Please, enter the city")
    private String deliveryCity;

    @NotBlank(message = "Please, enter the street")
    private String deliveryStreet;

    @NotBlank(message = "Please, enter the house number")
    private String deliveryHouse;

    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Shawarma> shawarmas = new ArrayList<>();

    public void addShawarma(Shawarma shawarma){
        this.shawarmas.add(shawarma);
    }



}
