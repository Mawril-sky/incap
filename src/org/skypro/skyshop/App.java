package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // 1. Добавление продуктов в корзину
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new Product("Яблоко", 50));
        basket.addProduct(new Product("Хлеб", 80));
        basket.addProduct(new Product("Молоко", 90));

        // 2. Добавление продукта в заполненную корзину
        // Создаём вторую корзину и заполняем её до отказа
        ProductBasket fullBasket = new ProductBasket();
        fullBasket.addProduct(new Product("Сыр", 300));
        fullBasket.addProduct(new Product("Чай", 150));
        fullBasket.addProduct(new Product("Кофе", 400));
        fullBasket.addProduct(new Product("Сахар", 60));
        fullBasket.addProduct(new Product("Масло", 120));
        fullBasket.addProduct(new Product("Крупа", 70));
        // Вывод: Невозможно добавить продукт

        // 3. Печать содержимого корзины с несколькими товарами
        System.out.println("Содержимое первой корзины:");
        basket.printBasket();
        System.out.println();

        // 4. Получение стоимости корзины с несколькими товарами
        System.out.println("Стоимость корзины: " + basket.getTotalCost());
        System.out.println();

        // 5. Поиск товара, который есть в корзине
        System.out.println("Есть ли \"Хлеб\" в корзине? " + basket.containsProductByName("Хлеб"));
        // true

        // 6. Поиск товара, которого нет в корзине
        System.out.println("Есть ли \"Ананас\" в корзине? " + basket.containsProductByName("Ананас"));
        // false
        System.out.println();

        // 7. Очистка корзины
        basket.clearBasket();

        // 8. Печать содержимого пустой корзины
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();
        // в корзине пусто
        System.out.println();

        // 9. Получение стоимости пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());
        // 0
        System.out.println();

        // 10. Поиск товара по имени в пустой корзине
        System.out.println("Есть ли \"Молоко\" в пустой корзине? " + basket.containsProductByName("Молоко"));
        // false
    }
}
