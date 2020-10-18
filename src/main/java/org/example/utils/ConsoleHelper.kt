package org.example.utils

import java.util.*

object ConsoleHelper {
    fun ask(msg: String?): Array<String> {
        print(msg)
        return Scanner(System.`in`).nextLine().split(" ").toTypedArray()
    }
}
