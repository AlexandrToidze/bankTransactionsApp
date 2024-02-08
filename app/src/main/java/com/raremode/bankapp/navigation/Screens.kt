package com.raremode.bankapp.navigation

sealed class Screens(val route: String) {
    object History : Screens(route = "history_screen")
    object Details : Screens(
        route = "details_screen"
                + "/{service_key}"
                + "/{type_key}"
                + "/{sum_key}"
                + "/{subtitle_key}"
                + "/{trDate_key}"
    )
}
