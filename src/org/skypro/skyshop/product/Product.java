package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // Search term для товара — его имя
    @Override
    public String getSearchTerm() {
        return getName();
    }

    // Тип контента для любого товара — PRODUCT
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public abstract String toString();
}
