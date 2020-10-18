package org.example.enums

enum class AppMode {
    D, R, EXIT;

    companion object {
        fun of(mode: String) = values().firstOrNull {
            it.toString().equals(mode, true)
        }

        fun of(mode: AppMode) = values().firstOrNull { it == mode }

//            for (appMode: AppMode in values()) {
//                if (appMode.toString().equals(mode, true))
//                    return appMode
//            }
//            return null
    }
}
