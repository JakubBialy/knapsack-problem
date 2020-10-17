package org.example.solvers;

import org.example.model.Item;
import org.example.model.KnapsackCase;
import org.example.model.KnapsackCaseSolution;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingSolver implements SolverInterface {
    private static boolean[] solve(int[][] inputTable, boolean[][][] memArray, int capacity, int n) {
        boolean[] result = new boolean[inputTable[0].length];

        if (n >= 0 && memArray[n][capacity] != null) {
            return memArray[n][capacity];
        }

        if (capacity == 0 || n == -1) {
            return result;
        } else if (inputTable[0][n] > capacity) {
            result = solve(inputTable, memArray, capacity, n - 1);
        } else {
            boolean[] tmp = solve(inputTable, memArray, capacity, n - 1);
            boolean[] tmp2 = or(insert(result, true, n), solve(inputTable, memArray, capacity - inputTable[0][n], n - 1));

            if (computeTotalValue(inputTable, tmp) > computeTotalValue(inputTable, tmp2)) {
                result = tmp;
            } else {
                result = tmp2;
            }
        }

        memArray[n][capacity] = result;
        return result;
    }

    private static int computeTotalValue(int[][] inputTable, boolean[] selected) {
        if (inputTable[1].length != selected.length) throw new IllegalArgumentException();

        int sum = 0;
        for (int i = 0; i < inputTable[1].length; i++) {
            if (selected[i]) {
                sum += inputTable[1][i];
            }
        }

        return sum;
    }

    private static boolean[] or(boolean[] first, boolean[] second) {
        if (first.length != second.length) throw new IllegalArgumentException();

        boolean[] result = new boolean[first.length];

        for (int i = 0; i < first.length; i++) {
            result[i] = first[i] || second[i];
        }

        return result;
    }

    private static boolean[] insert(boolean[] tab, boolean val, int index) {
        boolean[] result = new boolean[tab.length];
        System.arraycopy(tab, 0, result, 0, tab.length);
        result[index] = val;
        return result;
    }

    @Override
    public KnapsackCaseSolution solve(KnapsackCase knapsackCase) {
        final List<Item> items = knapsackCase.getItemsCopy();
        final int knapsackCapacity = knapsackCase.getKnapsackCapacity();

        int[][] primitiveTable = new int[2][];
        primitiveTable[0] = new int[items.size()];
        primitiveTable[1] = new int[items.size()];

        for (int i = 0; i < items.size(); i++) {
            primitiveTable[0][i] = items.get(i).getWeight();
            primitiveTable[1][i] = items.get(i).getValue();
        }

        boolean[][][] memArray = new boolean[items.size()][][];

        for (int i = 0; i < memArray.length; i++) {
            memArray[i] = new boolean[knapsackCapacity + 1][];
        }

        final boolean[] primitiveSolution = solve(primitiveTable, memArray, knapsackCapacity, items.size() - 1);
        List<Item> chosenItems = new ArrayList<>();
        for (int i = 0; i < primitiveSolution.length; i++) {
            if (primitiveSolution[i]) {
                chosenItems.add(items.get(i));
            }
        }

        return new KnapsackCaseSolution(chosenItems, knapsackCapacity);
    }
}
