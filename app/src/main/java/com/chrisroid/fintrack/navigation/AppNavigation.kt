package com.chrisroid.fintrack.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val showBottomBar = remember { mutableStateOf(true) }

    // Observe current route to show/hide bottom bar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    LaunchedEffect(currentRoute) {
        showBottomBar.value = when(currentRoute) {
            Routes.MAIN_HOME,
            Routes.BUDGETS,
            Routes.SAVINGS,
            Routes.EXPENSES,
            Routes.ACCOUNT -> true
            else -> false
        }
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar.value) {
                BottomNavigationBar(navController)
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "auth",
            modifier = Modifier.padding(padding)
        ) {
            authNavGraph(navController)
            mainNavGraph(navController)
        }
    }
}