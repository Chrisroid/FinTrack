package com.chrisroid.fintrack.navigation

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Routes.MAIN_HOME, R.drawable.home_selected, R.drawable.home_unselected),
        BottomNavItem("Budgets", Routes.BUDGETS, R.drawable.budget_selected, R.drawable.budget_unselected),
        BottomNavItem("Savings", Routes.SAVINGS, R.drawable.savings_selected, R.drawable.savings_unselected),
        BottomNavItem("Expenses", Routes.EXPENSES, R.drawable.expenses_selected, R.drawable.expenses_unselected),
        BottomNavItem("Account", Routes.ACCOUNT, R.drawable.account_selected, R.drawable.account_unselected)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF008080)
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if (selected) item.selectedIconRes else item.unselectedIconRes),
                        tint = if (selected) Color(0xFF008080) else Color.Gray,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        style = appText.copy(
                            fontSize = 12.sp,
                            color = if (selected) Color(0xFF008080) else Color.Gray
                        )
                    )
                },
                selected = selected,
//                selectedContentColor = Color(0xFF008080),
//                unselectedContentColor = Color.Gray,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIconRes: Int,
    val unselectedIconRes: Int
)