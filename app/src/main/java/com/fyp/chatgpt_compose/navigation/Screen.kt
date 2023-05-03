package com.fyp.chatgpt_compose.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object ChatScreen : Screen("chat_screen")

    // pass args ext function
    // works only with mandatory args
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}