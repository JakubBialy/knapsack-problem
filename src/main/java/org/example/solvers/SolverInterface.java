package org.example.solvers;

import org.example.model.KnapsackCase;
import org.example.model.KnapsackCaseSolution;

public interface SolverInterface {
    KnapsackCaseSolution solve(KnapsackCase knapsackCase);
}
