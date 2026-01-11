package com.example.projet_e_visa_s7iiaa.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object VisaApplication : Screen("visa_application")
    data object ApplicationTracking : Screen("application_tracking")
    data object Payment : Screen("payment")
    data object Profile : Screen("profile")
    data object Contact : Screen("contact")
    data object About : Screen("about")
}
