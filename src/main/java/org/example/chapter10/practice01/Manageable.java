package org.example.chapter10.practice01;

//관리할 수 있는...
// 인터페이스

import java.util.List;

public interface Manageable {
    //동작 관리 정의 - CRUD

    void add(Item item);
    void remove(String id);
    void updateStock(String id, int quantity);
    void listAll();

    // 검색기능
    List<Item> search(String keyword);
    List<Item> searchByCategory(String category);
    List<Item> searchByPriceRange(int minPrice, int maxPrice);


}
