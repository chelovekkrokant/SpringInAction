package com.github.chelovekkrokant.foodordering.shawarma;

import lombok.Data;

@Data
public class Packaging {
    private final String id;
    private final String name;
    private final Purpose purpose;
    public enum Purpose {
        GO, IN
    }
}
