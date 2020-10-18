package org.example.controllers

import org.apache.commons.cli.*
import org.example.ConsoleHelper
import org.example.enums.AppMode
import org.example.interfaces.Controller
import org.example.model.Item
import org.example.model.KnapsackCase
import org.example.solvers.DynamicProgrammingSolver
import org.example.solvers.RecursiveSolver

class MainController(
        private val dynamicController: Controller,
        private val recursiveController: Controller
) : Controller {

//    private val modeOption = Option(
//            "m",
//            "mode",
//            true, """Wybiera tryb programu. Możliwe tryby to:
//|D -> metoda dynamiczna,
//|R -> metoda rekurencyjna,
//|EXIT -> wyjście""".trimMargin())

    private val dynamicOption = Option("d", false, "Metoda dynamiczna")
    private val recursiveOption = Option("r", false, "Metoda rekursywna")
    private val exitOption = Option("e", false, "Wyjście z programu")

    private val options = Options().apply {
        addOption(dynamicOption)
        addOption(recursiveOption)
        addOption(exitOption)
    }

    private val parser = DefaultParser()

    override fun showHelp() {
        val formatter = HelpFormatter()
        formatter.printHelp("Problem plecakowy", options)
    }

    private fun containsRequiredOptions(cmd: CommandLine): Boolean {
        if (cmd.args.contains(dynamicOption.opt)
                || cmd.args.contains(recursiveOption.opt)
                || cmd.args.contains(exitOption.opt)) {
            return true
        }

        System.err.println("Nie ma podanego trybu.")
        return false
    }


    override fun start() {
        var repeatLoop = true
        do {
            try {
                println("""
                    +++++++++++++
                    + MAIN MENU +
                    +++++++++++++
                """.trimIndent())

                showHelp()

                val args = ConsoleHelper.ask(">> ")
                val cmd = parser.parse(options, args)
                containsRequiredOptions(cmd)

                val parsedMode = AppMode.of(cmd.args[0])

                when (parsedMode) {
                    AppMode.D -> {
//                        println("Dynamiczne")
//                        val knapsackCase = KnapsackCase(10).apply {
//                            addItem(Item(3, 100))
//                            addItem(Item(1, 1))
//                            addItem(Item(7, 150))
//                            addItem(Item(1, 1))
//                            addItem(Item(15, 900))
//                        }
//
//                        DynamicProgrammingSolver().solve(knapsackCase).printDescription()
                        dynamicController.start()
                    }
                    AppMode.R -> {
//                        println("Rekursywne")
//                        val knapsackCase = KnapsackCase(10).apply {
//                            addItem(Item(3, 100))
//                            addItem(Item(1, 1))
//                            addItem(Item(7, 150))
//                            addItem(Item(1, 1))
//                            addItem(Item(15, 900))
//                        }
//
//                        RecursiveSolver().solve(knapsackCase).printDescription()
                        recursiveController.start()
                    }
                    AppMode.E -> repeatLoop = false
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            println()
        } while (repeatLoop)

    }

}
