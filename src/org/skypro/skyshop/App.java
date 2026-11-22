package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // Товары трёх типов
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new SimpleProduct("Хлеб", 80));
        basket.addProduct(new DiscountedProduct("Ноутбук", 1000, 20));   // 1000 - 20% = 800
        basket.addProduct(new FixPriceProduct("Скрепка"));                // фиксированная цена

        // Печать содержимого
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // Стоимость
        System.out.println("Стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли \"Ноутбук\"? " + basket.containsProductByName("Ноутбук"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли \"Ананас\"? " + basket.containsProductByName("Ананас"));

        // Очистка и пустая корзина
        basket.clearBasket();
        System.out.println("Содержимое после очистки:");
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли \"Хлеб\" в пустой корзине? " + basket.containsProductByName("Хлеб"));
    }
}
