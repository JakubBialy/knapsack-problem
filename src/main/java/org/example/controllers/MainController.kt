package org.example.controllers

import org.apache.commons.cli.*
import org.example.utils.ConsoleHelper

class MainController(
        private val dynamicController: Controller,
        private val recursiveController: Controller
) : Controller {

    override var repeatLoop = true

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
                    AppMode.D -> dynamicController.start()
                    AppMode.R -> recursiveController.start()
                    AppMode.E -> repeatLoop = false
                }
            } catch (e: ParseException) {
                System.err.println("Źle wprowadzone dane")
            }
            println()
        } while (repeatLoop)

    }

}
