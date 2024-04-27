package com.artjomsporss.cachedemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final List<String> addedItems = new ArrayList<>();

    public void post(String itemName) {
        this.addedItems.add(itemName + addedItems.size()); // add items to list simulating changing data on the backend
    }

    public List<String> get(String itemName) {
        List<String> toReturn = new ArrayList<>(this.addedItems); // add all the items added using post

        // generate dummy data for requested itemName
        for (int i = 0; i < 2_000_000; i++) {
           toReturn.add(itemName + i);
        }

        return toReturn;
    }
}
