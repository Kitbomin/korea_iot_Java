package org.example.chapter10.practice02.service;

import org.example.chapter10.practice02.entity.Item;
import org.example.chapter10.practice02.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InventoryServiceImpl implements InventoryService{
    private final ItemRepository repository;

    public InventoryServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addItem(Item item) {
        repository.addItem(item); //DB 호출을 서비스에서
    }

    @Override
    public List<Item> getItemsByCategory(String category) {
        Set<Item> allItems = repository.findAll();
        List<Item> categoryItems = new ArrayList<Item>();

        for (Item item: allItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                categoryItems.add(item);
            }
        }

        return categoryItems;
    }

    @Override
    public boolean updateItemPrice(String itemId, int newPrice) {
        // 수정할 아이템이 저장소에 존재하는 지 확인
        boolean isUpdated = false;

        Item item = repository.findById(itemId);
        if (item != null) {
            item.setPrice(newPrice);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public void deleteItem(String itemId) {
        Item item = repository.findById(itemId);
        if (item != null) {
            repository.removeItem(itemId);
        }
    }
}
