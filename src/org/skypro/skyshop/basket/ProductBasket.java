package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products; // приватный массив — прямой доступ извне невозможен
    private int size;

    public ProductBasket() {
         // массив из пяти элементов
        this.size = 0;
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (size == products.length) {
            System.out.println("В корзине нет свободного места");
            return;
        }
        products[size] = product;
        size++;
    }

    /**
     * Возвращает общую стоимость корзины.
     */
    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    /**
     * Печатает содержимое корзины.
     * Если корзина пуста — печатает «в корзине пусто».
     */
    public void printBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    /**
     * Проверяет, есть ли продукт с указанным именем в корзине.
     */
    public boolean containsProductByName(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Очищает корзину, проставляя всем элементам массива null.
     */
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        size = 0;
    }
}
