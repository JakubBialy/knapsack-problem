package org.example.enums

enum class AppMode {
    D, R, E;

    companion object {
        fun of(mode: String) = values().firstOrNull {
            it.toString().equals(mode, true)
        }
    }
}
