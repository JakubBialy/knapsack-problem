package org.example;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.example.model.Item;
import org.example.model.KnapsackCase;
import org.example.model.KnapsackCaseSolution;
import org.example.solvers.RecursiveSolver;

public class App {
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.start();
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
