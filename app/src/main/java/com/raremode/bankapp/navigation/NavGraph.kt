package com.raremode.bankapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.ui.screens.details.TransactionDetailsScreen
import com.raremode.bankapp.ui.screens.history.TransactionHistoryFragment

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.History.route
    ) {
        composable(
            route = Screens.History.route
        ) {
            TransactionHistoryFragment(navController)
        }

        composable(
            route = Screens.Details.route,
            arguments = listOf(
                navArgument(name = "service_key") {
                type = NavType.StringType },
                navArgument(name = "type_key") {
                    type = NavType.StringType },
                navArgument(name = "sum_key") {
                    type = NavType.FloatType },
                navArgument(name = "subtitle_key") {
                    type = NavType.StringType },
                navArgument(name = "trDate_key") {
                    type = NavType.StringType },
                )
        ) { navBackStackEntry ->
            val service = navBackStackEntry.arguments?.getString("service_key") ?: ""
            val type = navBackStackEntry.arguments?.getString("type_key") ?: ""
            val sum = navBackStackEntry.arguments?.getDouble("sum_key") ?: 0.0
            val subtitle = navBackStackEntry.arguments?.getString("subtitle_key") ?: ""
            val trDate = navBackStackEntry.arguments?.getString("trDate_key") ?: ""

            // pass an empty string for now
            // we'll send the original data
            TransactionDetailsScreen(service = service, type = type, sum = sum, subtitle = subtitle, trDate = trDate,
                onDismiss = {
                    navController.navigate(route = "history_screen")
                })
        }
    }
}