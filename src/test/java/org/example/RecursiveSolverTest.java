package org.example;

import org.example.model.Item;
import org.example.model.KnapsackCase;
import org.example.model.KnapsackCaseSolution;
import org.example.solvers.RecursiveSolver;
import org.junit.Assert;
import org.junit.Test;

public class RecursiveSolverTest {
    @Test
    public void solveEmpty() {
        KnapsackCase knapsackCase = new KnapsackCase(10);
        final KnapsackCaseSolution caseSolution = new RecursiveSolver().solve(knapsackCase);

        Assert.assertTrue(caseSolution.isValid());
        Assert.assertEquals(10, caseSolution.getKnapsackCapacity());
        Assert.assertEquals(0, caseSolution.getTotalItemsWeight());
        Assert.assertEquals(0, caseSolution.getTotalItemsValue());
        Assert.assertTrue(caseSolution.getItemsCopy().isEmpty());
    }

    @Test
    public void simpleCase() {
        KnapsackCase knapsackCase = new KnapsackCase(10);
        knapsackCase.addItem(new Item(3, 100));
        knapsackCase.addItem(new Item(7, 150));
        knapsackCase.addItem(new Item(15, 900));

        final KnapsackCaseSolution caseSolution = new RecursiveSolver().solve(knapsackCase);

        Assert.assertTrue(caseSolution.isValid());
        Assert.assertEquals(10, caseSolution.getKnapsackCapacity());
        Assert.assertEquals(10, caseSolution.getTotalItemsWeight());
        Assert.assertEquals(250, caseSolution.getTotalItemsValue());
        Assert.assertEquals(2, caseSolution.getItemsCopy().size());
    }

    @Test
    public void simpleCase_2() {
        KnapsackCase knapsackCase = new KnapsackCase(10);
        knapsackCase.addItem(new Item(3, 100));
        knapsackCase.addItem(new Item(3, 100));
        knapsackCase.addItem(new Item(4, 150));
        knapsackCase.addItem(new Item(15, 900));

        final KnapsackCaseSolution caseSolution = new RecursiveSolver().solve(knapsackCase);

        Assert.assertTrue(caseSolution.isValid());
        Assert.assertEquals(10, caseSolution.getKnapsackCapacity());
        Assert.assertEquals(10, caseSolution.getTotalItemsWeight());
        Assert.assertEquals(350, caseSolution.getTotalItemsValue());
        Assert.assertEquals(3, caseSolution.getItemsCopy().size());
    }
}
