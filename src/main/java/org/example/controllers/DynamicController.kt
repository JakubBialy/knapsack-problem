package org.example.controllers

import org.apache.commons.cli.ParseException
import org.example.utils.ConsoleHelper
import org.example.model.Item
import org.example.model.KnapsackCase
import org.example.solvers.DynamicProgrammingSolver

class DynamicController : Controller {
    override var repeatLoop = true
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

        knapsackCase = try {
            KnapsackCase(Integer.parseInt(args[0]))
        } catch (e: Exception) {
            System.err.println("Capacity error. Loading default capacity of 10")
            KnapsackCase(10)
        }

        println("Insert items in format [weight value]")
        println("If you want stop inserting items enter y/Y")

        do {
            try {
                val input = ConsoleHelper.ask(">> ")

                if ("y".equals(input[0], true))
                    repeatLoop = false
                else {
                    try {
                        val item = Item(Integer.parseInt(input[0]), Integer.parseInt(input[1]))
                        knapsackCase.addItem(item)
                    } catch (e: Exception) {
                        System.err.println("Inserting item data error")
                    }
                }
            } catch (e: ParseException) {
                System.err.println("Inserting data error")
            }
        } while (repeatLoop)

        knapsackCase.printDescription()

        val solution = DynamicProgrammingSolver().solve(knapsackCase)
        solution.printDescription()
    }
}
