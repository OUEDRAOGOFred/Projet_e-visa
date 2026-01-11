package com.example.projet_e_visa_s7iiaa.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Description
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Accueil",
        icon = Icons.Default.Home,
        screen = Screen.Home
    ),
    BottomNavItem(
        title = "Demande",
        icon = Icons.Default.Description,
        screen = Screen.VisaApplication
    ),
    BottomNavItem(
        title = "Suivi",
        icon = Icons.Default.Search,
        screen = Screen.ApplicationTracking
    ),
    BottomNavItem(
        title = "Contact",
        icon = Icons.Default.ContactMail,
        screen = Screen.Contact
    ),
    BottomNavItem(
        title = "Profil",
        icon = Icons.Default.Person,
        screen = Screen.Profile
    )
)
