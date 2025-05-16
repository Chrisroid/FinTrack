package com.chrisroid.fintrack.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.chrisroid.fintrack.ui.main.account.AccountScreen
import com.chrisroid.fintrack.ui.main.budgets.BudgetDetailsScreen
import com.chrisroid.fintrack.ui.main.budgets.BudgetListScreen
import com.chrisroid.fintrack.ui.main.budgets.BudgetPreviewScreen
import com.chrisroid.fintrack.ui.main.budgets.BudgetsScreen
import com.chrisroid.fintrack.ui.main.budgets.CreateBudgetScreen1
import com.chrisroid.fintrack.ui.main.budgets.CreateBudgetScreen2
import com.chrisroid.fintrack.ui.main.expenses.AllExpensesScreen
import com.chrisroid.fintrack.ui.main.expenses.ExpensesScreen
import com.chrisroid.fintrack.ui.main.expenses.SortExpensesScreen
import com.chrisroid.fintrack.ui.main.home.AccountDetailsScreen
import com.chrisroid.fintrack.ui.main.home.HomeScreen
import com.chrisroid.fintrack.ui.main.home.InsightsScreen
import com.chrisroid.fintrack.ui.main.home.LinkedAccountsScreen
import com.chrisroid.fintrack.ui.main.savings.CreateSavingsScreen1
import com.chrisroid.fintrack.ui.main.savings.CreateSavingsScreen2
import com.chrisroid.fintrack.ui.main.savings.CreateSavingsScreen3
import com.chrisroid.fintrack.ui.main.savings.SavingsDetailsScreen
import com.chrisroid.fintrack.ui.main.savings.SavingsListScreen
import com.chrisroid.fintrack.ui.main.savings.SavingsPreviewScreen
import com.chrisroid.fintrack.ui.main.savings.SavingsScreen

@RequiresApi(Build.VERSION_CODES.P)
fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(
        startDestination = Routes.MAIN_HOME,
        route = "main"
    ) {
        // Home group
        composable(Routes.MAIN_HOME) {
            HomeScreen()
        }
        composable(Routes.INSIGHTS) { InsightsScreen() }
        composable(Routes.LINKED_ACCOUNTS) { LinkedAccountsScreen(
            onAccountClick = { accountId ->
                navController.navigate("${Routes.ACCOUNT_DETAILS}/$accountId")
            }
        )}
        composable(
            route = "${Routes.ACCOUNT_DETAILS}/{accountId}",
            arguments = listOf(navArgument("accountId") { type = NavType.StringType })
        ) { backStackEntry ->
            AccountDetailsScreen(backStackEntry.arguments?.getString("accountId"))
        }

        // Budgets group
        composable(Routes.BUDGETS) { BudgetsScreen(
            onBudgetClick = { navController.navigate(Routes.BUDGET_DETAILS) }
        )}
        composable(Routes.CREATE_BUDGET_1) {
            CreateBudgetScreen1 { navController.navigate(Routes.CREATE_BUDGET_2) }
        }
        composable(Routes.CREATE_BUDGET_2) {
            CreateBudgetScreen2 { navController.navigate(Routes.BUDGET_PREVIEW) }
        }
        composable(Routes.BUDGET_PREVIEW) {
            BudgetPreviewScreen { navController.navigate(Routes.BUDGET_DETAILS) }
        }
        composable(Routes.BUDGET_DETAILS) { BudgetDetailsScreen() }
        composable(Routes.BUDGET_LIST) { BudgetListScreen(
            onBudgetClick = { budgetId ->
                navController.navigate("${Routes.BUDGET_DETAILS}/$budgetId")
            }
        )}

        // Savings group
        composable(Routes.SAVINGS) { SavingsScreen(
            onSavingsClick = {navController.navigate(Routes.CREATE_SAVINGS_1)}
        )}
        composable(Routes.CREATE_SAVINGS_1) {
            CreateSavingsScreen1 { navController.navigate(Routes.CREATE_SAVINGS_2) }
        }
        composable(Routes.CREATE_SAVINGS_2) {
            CreateSavingsScreen2 { navController.navigate(Routes.CREATE_SAVINGS_3) }
        }
        composable(Routes.CREATE_SAVINGS_3) {
            CreateSavingsScreen3 { navController.navigate(Routes.SAVINGS_PREVIEW) }
        }
        composable(Routes.SAVINGS_PREVIEW) {
            SavingsPreviewScreen { navController.navigate(Routes.SAVINGS_DETAILS) }
        }
        composable(Routes.SAVINGS_DETAILS) { SavingsDetailsScreen() }
//        composable(Routes.SAVINGS_LIST) { SavingsListScreen(
//            onSavingsClick = { savingsId ->
//                navController.navigate("${Routes.SAVINGS_DETAILS}/$savingsId")
//            }
//        )}

        // Expenses group
        composable(Routes.EXPENSES) {
            ExpensesScreen(
                onAllExpenses = { navController.navigate(Routes.ALL_EXPENSES) },
                onSortExpenses = { navController.navigate(Routes.SORT_EXPENSES) }
            )
        }

        composable(Routes.ALL_EXPENSES) { AllExpensesScreen() }
        composable(Routes.SORT_EXPENSES) { SortExpensesScreen() }

        // Account
        composable(Routes.ACCOUNT) { AccountScreen() }
    }
}