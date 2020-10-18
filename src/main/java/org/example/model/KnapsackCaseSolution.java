package org.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class KnapsackCaseSolution {
    private final List<Item> items;
    private final int totalItemsValue;
    private final int totalItemsWeight;
    private final int knapsackCapacity;
    private final boolean isValid;

    public KnapsackCaseSolution(List<Item> items, int knapsackCapacity) {
        this.items = new ArrayList<>(items);
        this.knapsackCapacity = knapsackCapacity;
        this.totalItemsWeight = computeTotalWeight(this.items);
        this.totalItemsValue = computeTotalValue(this.items);
        this.isValid = totalItemsWeight <= this.knapsackCapacity;
    }

    private static int computeTotalWeight(Collection<Item> items) {
        int totalWeight = 0;
        for (Item i : items) {
            totalWeight += i.getWeight();
        }

        return totalWeight;
    }

    private static int computeTotalValue(Collection<Item> items) {
        int totalValue = 0;
        for (Item i : items) {
            totalValue += i.getValue();
        }

        return totalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnapsackCaseSolution that = (KnapsackCaseSolution) o;
        return totalItemsValue == that.totalItemsValue &&
                totalItemsWeight == that.totalItemsWeight &&
                knapsackCapacity == that.knapsackCapacity &&
                isValid == that.isValid &&
                items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, totalItemsValue, totalItemsWeight, knapsackCapacity, isValid);
    }

    public List<Item> getItemsCopy() {
        return new ArrayList<>(items);
    }

    public int getTotalItemsValue() {
        return totalItemsValue;
    }

    public int getTotalItemsWeight() {
        return totalItemsWeight;
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public boolean isValid() {
        return isValid;
    }

    public void printDescription() {
        System.out.println("----------> Problem description: ");
        System.out.println("Items to solve: " + this.getItemsCopy());
        System.out.println("Knapsack capacity: " + this.getKnapsackCapacity());
        System.out.println("Total items value: " + this.getTotalItemsValue());
        System.out.println("Total items weight: " + this.getTotalItemsWeight());
        System.out.println("Is valid solution: " + this.isValid());
        System.out.println("Items count in knapsack: " + this.getItemsCopy().size());
        System.out.println("Items in knapsack: " + this.getItemsCopy());
        System.out.println("----------> END");
    }
}
