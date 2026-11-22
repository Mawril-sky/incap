package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    public void add(Searchable searchable) {
        if (searchable == null || count == searchables.length) {
            return;
        }
        searchables[count++] = searchable;
    }

    /**
     * Возвращает до 5 первых подходящих результатов.
     * Незаполненные элементы массива остаются null.
     */
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        for (int i = 0; i < searchables.length && found < 5; i++) {
            Searchable searchable = searchables[i];
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchTerm().contains(query)) {
                results[found++] = searchable;
                if (found == 5) {
                    break; // больше 5 результатов не нужно
                }
            }
        }
        return results;
    }
}
