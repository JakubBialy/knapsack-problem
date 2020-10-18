package org.example.controllers

import org.apache.commons.cli.ParseException
import org.example.ConsoleHelper
import org.example.interfaces.Controller
import org.example.model.Item
import org.example.model.KnapsackCase
import org.example.solvers.DynamicProgrammingSolver

class DynamicController: Controller {
    var repeatLoop = true
    lateinit var knapsackCase: KnapsackCase

    override fun showHelp() {}

    override fun start() {
        repeatLoop = true

        println("""
                    ++++++++++++++++++++
                    + DYNAMIC METHOD +
                    ++++++++++++++++++++
                """.trimIndent())

        println("Insert knapsack capacity")
        val args = ConsoleHelper.ask(">> ")
        knapsackCase = KnapsackCase(Integer.parseInt(args[0]))
        println("Insert items in format [weight value]")
        println("If you want stop inserting items enter y/Y")
        do {
            try {
                val input = ConsoleHelper.ask(">> ")

                if (input[0] == "y" || input[0] == "Y")
                    repeatLoop = false
                else {
                    val item = Item(Integer.parseInt(input[0]), Integer.parseInt(input[1]))
                    knapsackCase.addItem(item)
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        } while (repeatLoop)

        println("Knapsack info")
        println("Items to solve: " + knapsackCase.itemsCopy)
        println("Knapsack capacity: " + knapsackCase.knapsackCapacity)

        val solution = DynamicProgrammingSolver().solve(knapsackCase)
        println("Solution info")
        println("Total items value: " + solution.totalItemsValue);
        println("Total items weight: " + solution.totalItemsWeight);
        println("Is valid solution: " + solution.isValid);
        println("Items count in knapsack: " + solution.itemsCopy.size)
        println("Items in knapsack: " + solution.itemsCopy)

    }
}
