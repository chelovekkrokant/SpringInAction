package com.github.chelovekkrokant.foodordering.shawarma;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    private String deliveryName;
    private String deliveryCity;
    private String deliveryStreet;
    private String deliveryHouse;
    private String clientExpiration;
    private String clientNumber;
    private String clientCVV;

    private List<Shawarma> shawarmas = new ArrayList<>();

    public void addShawarma(Shawarma shawarma){
        this.shawarmas.add(shawarma);
    }



}
