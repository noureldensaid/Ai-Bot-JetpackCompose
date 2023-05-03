package com.fyp.chatgpt_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fyp.chatgpt_compose.ui.screens.ChatScreen
import com.fyp.chatgpt_compose.ui.screens.SplashScreen


@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(route = Screen.ChatScreen.route) { ChatScreen(navController) }
    }


}

