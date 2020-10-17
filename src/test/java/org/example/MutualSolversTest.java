package org.example;

import org.example.model.Item;
import org.example.model.KnapsackCase;
import org.example.model.KnapsackCaseSolution;
import org.example.solvers.DynamicProgrammingSolver;
import org.example.solvers.RecursiveSolver;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MutualSolversTest {
    public static final  ThreadLocalRandom random = ThreadLocalRandom.current();

    private static KnapsackCase generateRandomCase() {
        KnapsackCase knapsackCase = new KnapsackCase(random.nextInt(10_000));

        int itemsCount = random.nextInt(18);
        for (int i = 0; i < itemsCount; i++) {
            knapsackCase.addItem(new Item(random.nextInt(99) + 1, random.nextInt(99) + 1));
        }

        return knapsackCase;
    }

    @Test
    public void randomTests() {
        int testsCount = 1_000;

        for (int i = 0; i < testsCount; i++) {
            KnapsackCase knapsackCase = generateRandomCase();

            System.out.println(knapsackCase);

            final KnapsackCaseSolution recursiveSolution = new RecursiveSolver().solve(knapsackCase);
            final KnapsackCaseSolution dynamicSolution = new DynamicProgrammingSolver().solve(knapsackCase);

            Assert.assertTrue(recursiveSolution.isValid());
            Assert.assertTrue(dynamicSolution.isValid());
            Assert.assertEquals(recursiveSolution.getKnapsackCapacity(), dynamicSolution.getKnapsackCapacity());
            Assert.assertEquals(recursiveSolution.getTotalItemsWeight(), dynamicSolution.getTotalItemsWeight());
            Assert.assertEquals(recursiveSolution.getTotalItemsValue(), dynamicSolution.getTotalItemsValue());

            Assert.assertEquals(recursiveSolution.getItemsCopy().size(), dynamicSolution.getItemsCopy().size());
        }
    }
}
