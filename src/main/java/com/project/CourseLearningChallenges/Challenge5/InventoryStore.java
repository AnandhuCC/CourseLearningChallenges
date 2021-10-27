package com.project.CourseLearningChallenges.Challenge5;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InventoryStore {

    private Map<Long, Item> inventory = new HashMap<>();

    public boolean addItem(Item item) {
        if(inventory.containsKey(item.getID()))
            return false;
        inventory.put(item.getID(), item);
        return true;
    }

    public boolean isPresent(Long id) {
        return inventory.containsKey(id);
    }

    public Optional<Item> getItem(Long id) {
        return Optional.ofNullable(inventory.getOrDefault(id, null));
    }
}
