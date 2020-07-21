package com.cel.hexarchsample.domain.model;

import com.cel.hexarchsample.domain.model.vobjects.Money;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Product {

    @RequiredArgsConstructor(staticName = "of")
    public static class ProductId {
        public final UUID value;
    }

    private String name;
    private Money price;
    private int amount;

    public Product(String name, Money price, int amount) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Stock value is below zero");
        }

        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Money subtotal() {
        return price.multiplyBy(amount);
    }

    public String name() {
        return name;
    }
}
