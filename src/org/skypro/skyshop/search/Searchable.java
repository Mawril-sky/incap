package org.skypro.skyshop.search;

public interface Searchable {
    // Текст, по которому ищем
    String getSearchTerm();

    // Тип контента: PRODUCT или ARTICLE
    String getContentType();

    // Имя Searchable-объекта
    String getName();

    // Строка вида «имя — тип»
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}
