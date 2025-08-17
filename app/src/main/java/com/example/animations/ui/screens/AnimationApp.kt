package com.example.animations.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animations.navigation.Destination
import com.example.animations.navigation.Home

@Composable
fun AnimationApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Any = Home
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Destination.Box> {
            BoxScreen()
        }
        composable<Destination.List> {
            ListScreen()
        }
    }
}