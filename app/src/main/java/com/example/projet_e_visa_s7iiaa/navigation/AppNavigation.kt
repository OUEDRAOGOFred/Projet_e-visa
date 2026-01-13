package com.example.projet_e_visa_s7iiaa.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projet_e_visa_s7iiaa.screens.AboutScreen
import com.example.projet_e_visa_s7iiaa.screens.ApplicationTrackingScreen
import com.example.projet_e_visa_s7iiaa.screens.ContactScreen
import com.example.projet_e_visa_s7iiaa.screens.HomeScreen
import com.example.projet_e_visa_s7iiaa.screens.PaymentScreen
import com.example.projet_e_visa_s7iiaa.screens.ProfileScreen
import com.example.projet_e_visa_s7iiaa.screens.SplashScreen
import com.example.projet_e_visa_s7iiaa.screens.VisaApplicationScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        
        composable(Screen.VisaApplication.route) {
            VisaApplicationScreen(navController = navController)
        }
        
        composable(Screen.ApplicationTracking.route) {
            ApplicationTrackingScreen(navController = navController)
        }
        
        composable(Screen.Payment.route) {
            PaymentScreen(navController = navController)
        }
        
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        
        composable(Screen.Contact.route) {
            ContactScreen(navController = navController)
        }
        
        composable(Screen.About.route) {
            AboutScreen(navController = navController)
        }
    }
}
