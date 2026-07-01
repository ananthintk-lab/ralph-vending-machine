package dev.venga.ralph_vending_machine.model;

import java.math.BigDecimal;

public enum Product {

    COLA("Cola", new BigDecimal("1.50")),
    DIET_COLA("Diet Cola", new BigDecimal("1.50")),
    WATER("Water", new BigDecimal("1.00")),
    ORANGE_JUICE("Orange Juice", new BigDecimal("2.00")),
    CHIPS("Chips", new BigDecimal("1.75")),
    CANDY_BAR("Candy Bar", new BigDecimal("1.25")),
    GUM("Gum", new BigDecimal("0.75"));

    private final String displayName;
    private final BigDecimal price;

    Product(String displayName, BigDecimal price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
