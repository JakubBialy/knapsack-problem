package org.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnapsackCase {
    private final ArrayList<Item> items;
    private final int knapsackCapacity;

    public KnapsackCase(int knapsackCapacity) {
        this.items = new ArrayList<>();
        this.knapsackCapacity = knapsackCapacity;
    }

    @Override
    public String toString() {
        return "KnapsackCase{" +
                "items=" + items +
                ", knapsackCapacity=" + knapsackCapacity +
                '}';
    }

    public List<Item> getItemsCopy() {
        return new ArrayList<>(items);
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItems(Collection<Item> items) {
        this.items.addAll(items);
    }
}
