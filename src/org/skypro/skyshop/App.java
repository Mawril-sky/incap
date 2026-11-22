package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        // Товары для демонстрации корзины
        Product apple = new SimpleProduct("Яблоко", 50);
        Product laptop = new DiscountedProduct("Ноутбук", 1000, 20);
        Product paperclip = new FixPriceProduct("Скрепка");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(laptop);
        basket.addProduct(paperclip);
        basket.printBasket();

        // Статьи
        Article appleArticle = new Article(
                "Польза яблок",
                "Яблоко — один из самых полезных фруктов. В нём много витаминов и клетчатки."
        );
        Article laptopArticle = new Article(
                "Как выбрать ноутбук",
                "Ноутбук стоит выбирать по процессору, объёму памяти и весу."
        );
        Article gardenArticle = new Article(
                "Садовые хитрости",
                "Скрепка отлично подходит для подвязки рассады к опоре."
        );

        // Движок поиска: добавляем все товары и статьи
        SearchEngine engine = new SearchEngine(10);
        engine.add(apple);
        engine.add(laptop);
        engine.add(paperclip);
        engine.add(appleArticle);
        engine.add(laptopArticle);
        engine.add(gardenArticle);

        // Несколько поисковых запросов
        System.out.println();
        printResults(engine, "яблоко");
        printResults(engine, "ноутбук");
        printResults(engine, "скрепка");
        printResults(engine, "ананас");
    }

    private static void printResults(SearchEngine engine, String query) {
        System.out.println("Поиск: \"" + query + "\"");
        Searchable[] results = engine.search(query);
        boolean found = false;
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("  " + result.getStringRepresentation());
                found = true;
            }
        }
        if (!found) {
            System.out.println("  Ничего не найдено");
        }
        System.out.println();
    }
}
