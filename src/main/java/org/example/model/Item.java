package org.example.model;

public class Item {
    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
