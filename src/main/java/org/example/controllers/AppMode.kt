package org.example.controllers

enum class AppMode {
    D, R, E;

    companion object {
        fun of(mode: String) = values().firstOrNull {
            it.toString().equals(mode, true)
        }
    }
}
