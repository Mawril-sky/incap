package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Цены у базового класса больше нет — метод абстрактный,
    // каждый тип товара возвращает свою цену по-своему.
    public abstract int getPrice();

    // Специальный ли товар. Базовая реализация — false,
    // классы со скидкой и с фиксированной ценой переопределят её на true.
    public boolean isSpecial() {
        return false;
    }

    // Каждый класс товара переопределит этот метод под свой формат вывода.
    @Override
    public abstract String toString();
}
