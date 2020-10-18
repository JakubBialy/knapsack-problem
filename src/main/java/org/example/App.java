package org.example;

import org.example.controllers.DynamicController;
import org.example.controllers.MainController;
import org.example.controllers.RecursiveController;
import org.example.controllers.Controller;

public class App {
    public static void main(String[] args) {

        final Controller dynamicController = new DynamicController();
        final Controller recursiveController = new RecursiveController();

        MainController mainController = new MainController(dynamicController, recursiveController);
        mainController.start();
//
//        KnapsackCase knapsackCase = new KnapsackCase(10);
//        knapsackCase.addItem(new Item(3, 100));
//        knapsackCase.addItem(new Item(1, 1));
//        knapsackCase.addItem(new Item(7, 150));
//        knapsackCase.addItem(new Item(1, 1));
//        knapsackCase.addItem(new Item(15, 900));
//
//        KnapsackCaseSolution solution = new RecursiveSolver().solve(knapsackCase);
//        solution.printDescription();

//        KnapsackCaseSolution solution = new RecursiveSolver().solve(knapsackCase);
//
//        System.out.println();
//        System.out.println("Items to solve: " + knapsackCase.getItemsCopy());
//        System.out.println("Knapsack capacity: " + knapsackCase.getKnapsackCapacity());
//        System.out.println("Total items value: " + solution.getTotalItemsValue());
//        System.out.println("Total items weight: " + solution.getTotalItemsWeight());
//        System.out.println("Is valid solution: " + solution.isValid());
//        System.out.println("Items count in knapsack: " + solution.getItemsCopy().size());
//        System.out.println("Items in knapsack: " + solution.getItemsCopy());
    }
}
