package org.example

import org.apache.commons.cli.*
import org.example.enums.AppMode
import org.example.model.Item
import org.example.model.KnapsackCase
import org.example.solvers.DynamicProgrammingSolver
import org.example.solvers.RecursiveSolver

class Controller {
//    private val modeOption = Option("m", "mode", true, "Wybiera tryb programu. Możliwe tryby to: D, R, EXIT.")
    private val dynamicOption = Option("d", "dynamic", true, "Metoda dynamiczna")
    private val recursiveOption = Option("r", "recursive", true, "Metoda rekursywna")
    private val exitOption = Option("e", "exit", false, "Wyjście z programu")

    private val options = Options().apply {
        addOption(dynamicOption)
        addOption(recursiveOption)
        addOption(exitOption)
    }

    private val parser = DefaultParser()

    private fun showHelp() {
        val formatter = HelpFormatter()
        formatter.printHelp("Problem plecakowy", options)
    }

//    private fun containsRequiredOptions(cmd: CommandLine): Boolean {
//        if (!cmd.hasOption(modeOption.opt)) {
//            System.err.println("Nie ma trybu: " + modeOption.longOpt + ".")
//            return false
//        }
//        return true
//    }

    public fun start() {
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
//                containsRequiredOptions(cmd)

                val parsedMode = AppMode.of(cmd.options[0].opt)

                when (parsedMode) {
                    AppMode.D -> {
                        println("Dynamiczne")
                        val knapsackCase = KnapsackCase(10).apply {
                            addItem(Item(3, 100))
                            addItem(Item(1, 1))
                            addItem(Item(7, 150))
                            addItem(Item(1, 1))
                            addItem(Item(15, 900))
                        }

                        DynamicProgrammingSolver().solve(knapsackCase).printDescription()
                    }
                    AppMode.R -> {
                        println("Rekursywne")
                        val knapsackCase = KnapsackCase(10).apply {
                            addItem(Item(3, 100))
                            addItem(Item(1, 1))
                            addItem(Item(7, 150))
                            addItem(Item(1, 1))
                            addItem(Item(15, 900))
                        }

                        RecursiveSolver().solve(knapsackCase).printDescription()
                    }
                    AppMode.EXIT -> repeatLoop = false
                }


            } catch (e: ParseException) {
                e.printStackTrace()
            }
            println()
        } while (repeatLoop)

    }

}
