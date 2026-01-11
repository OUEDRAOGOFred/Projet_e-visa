package com.example.projet_e_visa_s7iiaa.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projet_e_visa_s7iiaa.R
import com.example.projet_e_visa_s7iiaa.models.PersonalInfo
import com.example.projet_e_visa_s7iiaa.models.PassportInfo
import com.example.projet_e_visa_s7iiaa.models.TravelInfo
import com.example.projet_e_visa_s7iiaa.ui.components.CustomTopBar
import com.example.projet_e_visa_s7iiaa.ui.components.EVIsaCard
import com.example.projet_e_visa_s7iiaa.ui.components.EVIsaTextField
import com.example.projet_e_visa_s7iiaa.ui.components.PrimaryButton
import com.example.projet_e_visa_s7iiaa.ui.components.SecondaryButton

// Demande de visa avec formulaire multi-étapes
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisaApplicationScreen(navController: NavController) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var personalInfo by remember { mutableStateOf(PersonalInfo()) }
    var passportInfo by remember { mutableStateOf(PassportInfo()) }
    var travelInfo by remember { mutableStateOf(TravelInfo()) }
    
    val tabs = listOf("Infos", "Passeport", "Voyage", "Documents")
    
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Demande de visa",
                onNavigationClick = { navController.navigateUp() },
                showBackground = true
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { 
                            Text(
                                text = title,
                                fontWeight = if (selectedTab == index) FontWeight.SemiBold else FontWeight.Normal,
                                maxLines = 1,
                                style = MaterialTheme.typography.bodyMedium
                            ) 
                        }
                    )
                }
            }
            
            when (selectedTab) {
                0 -> PersonalInfoTab(personalInfo = personalInfo, onPersonalInfoChange = { personalInfo = it }, onNext = { selectedTab = 1 })
                1 -> PassportInfoTab(passportInfo = passportInfo, onPassportInfoChange = { passportInfo = it }, onNext = { selectedTab = 2 }, onPrevious = { selectedTab = 0 })
                2 -> TravelInfoTab(travelInfo = travelInfo, onTravelInfoChange = { travelInfo = it }, onNext = { selectedTab = 3 }, onPrevious = { selectedTab = 1 })
                3 -> DocumentsTab(onSubmit = { navController.navigateUp() }, onPrevious = { selectedTab = 2 })
            }
        }
    }
}

@Composable
fun PersonalInfoTab(personalInfo: PersonalInfo, onPersonalInfoChange: (PersonalInfo) -> Unit, onNext: () -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            EVIsaCard {
                Text("Informations personnelles", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Veuillez remplir tous les champs obligatoires", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        item { EVIsaTextField(value = personalInfo.firstName, onValueChange = { onPersonalInfoChange(personalInfo.copy(firstName = it)) }, label = "Prénom", placeholder = "Entrez votre prénom", leadingIcon = { Icon(Icons.Default.Person, null) }) }
        item { EVIsaTextField(value = personalInfo.lastName, onValueChange = { onPersonalInfoChange(personalInfo.copy(lastName = it)) }, label = "Nom", placeholder = "Entrez votre nom", leadingIcon = { Icon(Icons.Default.Person, null) }) }
        item { EVIsaTextField(value = personalInfo.dateOfBirth, onValueChange = { onPersonalInfoChange(personalInfo.copy(dateOfBirth = it)) }, label = "Date de naissance", placeholder = "JJ/MM/AAAA", leadingIcon = { Icon(Icons.Default.CalendarToday, null) }) }
        item { EVIsaTextField(value = personalInfo.nationality, onValueChange = { onPersonalInfoChange(personalInfo.copy(nationality = it)) }, label = "Nationalité", placeholder = "Entrez votre nationalité") }
        item { EVIsaTextField(value = personalInfo.email, onValueChange = { onPersonalInfoChange(personalInfo.copy(email = it)) }, label = "Email", placeholder = "exemple@email.com", leadingIcon = { Icon(Icons.Default.Email, null) }, keyboardType = KeyboardType.Email) }
        item { EVIsaTextField(value = personalInfo.phoneNumber, onValueChange = { onPersonalInfoChange(personalInfo.copy(phoneNumber = it)) }, label = "Téléphone", placeholder = "+226 XX XX XX XX", leadingIcon = { Icon(Icons.Default.Phone, null) }, keyboardType = KeyboardType.Phone) }
        item { EVIsaTextField(value = personalInfo.address, onValueChange = { onPersonalInfoChange(personalInfo.copy(address = it)) }, label = "Adresse", placeholder = "Adresse complète", leadingIcon = { Icon(Icons.Default.LocationOn, null) }, maxLines = 2) }
        item { EVIsaTextField(value = personalInfo.city, onValueChange = { onPersonalInfoChange(personalInfo.copy(city = it)) }, label = "Ville", placeholder = "Entrez votre ville") }
        item { EVIsaTextField(value = personalInfo.country, onValueChange = { onPersonalInfoChange(personalInfo.copy(country = it)) }, label = "Pays", placeholder = "Entrez votre pays") }
        item { PrimaryButton("Suivant", onClick = onNext, enabled = personalInfo.firstName.isNotEmpty() && personalInfo.lastName.isNotEmpty() && personalInfo.email.isNotEmpty()) }
    }
}

@Composable
fun PassportInfoTab(passportInfo: PassportInfo, onPassportInfoChange: (PassportInfo) -> Unit, onNext: () -> Unit, onPrevious: () -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            EVIsaCard {
                Text("Informations du passeport", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Assurez-vous que votre passeport est valide pour au moins 6 mois", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        item { EVIsaTextField(value = passportInfo.passportNumber, onValueChange = { onPassportInfoChange(passportInfo.copy(passportNumber = it)) }, label = "Numéro de passeport", placeholder = "Ex: BF123456") }
        item { EVIsaTextField(value = passportInfo.issueDate, onValueChange = { onPassportInfoChange(passportInfo.copy(issueDate = it)) }, label = "Date de délivrance", placeholder = "JJ/MM/AAAA", leadingIcon = { Icon(Icons.Default.CalendarToday, null) }) }
        item { EVIsaTextField(value = passportInfo.expiryDate, onValueChange = { onPassportInfoChange(passportInfo.copy(expiryDate = it)) }, label = "Date d'expiration", placeholder = "JJ/MM/AAAA", leadingIcon = { Icon(Icons.Default.CalendarToday, null) }) }
        item { EVIsaTextField(value = passportInfo.placeOfIssue, onValueChange = { onPassportInfoChange(passportInfo.copy(placeOfIssue = it)) }, label = "Lieu de délivrance", placeholder = "Lieu de délivrance") }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SecondaryButton("Précédent", onClick = onPrevious, modifier = Modifier.weight(1f))
                PrimaryButton("Suivant", onClick = onNext, modifier = Modifier.weight(1f), enabled = passportInfo.passportNumber.isNotEmpty())
            }
        }
    }
}

@Composable
fun TravelInfoTab(travelInfo: TravelInfo, onTravelInfoChange: (TravelInfo) -> Unit, onNext: () -> Unit, onPrevious: () -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            EVIsaCard {
                Text("Informations de voyage", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Séjour maximum de 90 jours", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        item { EVIsaTextField(value = travelInfo.arrivalDate, onValueChange = { onTravelInfoChange(travelInfo.copy(arrivalDate = it)) }, label = "Date d'arrivée", placeholder = "JJ/MM/AAAA", leadingIcon = { Icon(Icons.Default.CalendarToday, null) }) }
        item { EVIsaTextField(value = travelInfo.departureDate, onValueChange = { onTravelInfoChange(travelInfo.copy(departureDate = it)) }, label = "Date de départ", placeholder = "JJ/MM/AAAA", leadingIcon = { Icon(Icons.Default.CalendarToday, null) }) }
        item { EVIsaTextField(value = travelInfo.purposeOfVisit, onValueChange = { onTravelInfoChange(travelInfo.copy(purposeOfVisit = it)) }, label = "Motif de la visite", placeholder = "Ex: Tourisme") }
        item { EVIsaTextField(value = travelInfo.accommodationAddress, onValueChange = { onTravelInfoChange(travelInfo.copy(accommodationAddress = it)) }, label = "Adresse d'hébergement", placeholder = "Hôtel ou adresse", maxLines = 2) }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SecondaryButton("Précédent", onClick = onPrevious, modifier = Modifier.weight(1f))
                PrimaryButton("Suivant", onClick = onNext, modifier = Modifier.weight(1f), enabled = travelInfo.arrivalDate.isNotEmpty())
            }
        }
    }
}

@Composable
fun DocumentsTab(onSubmit: () -> Unit, onPrevious: () -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            EVIsaCard {
                Text("Documents requis", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Veuillez préparer les documents suivants :", style = MaterialTheme.typography.bodyMedium)
            }
        }
        item {
            EVIsaCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    DocItem("Photo d'identité récente")
                    DocItem("Copie du passeport")
                    DocItem("Justificatif d'hébergement")
                    DocItem("Billet d'avion (si disponible)")
                }
            }
        }
        item {
            EVIsaCard {
                Text("Frais de visa", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("50 000 FCFA", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Le paiement sera effectué à l'étape suivante", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SecondaryButton("Précédent", onClick = onPrevious, modifier = Modifier.weight(1f))
                PrimaryButton("Soumettre", onClick = onSubmit, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun DocItem(text: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("•", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(end = 8.dp))
        Text(text, style = MaterialTheme.typography.bodyMedium)
    }
}

// Suivi de demande
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTrackingScreen(navController: NavController) {
    var trackingNumber by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }
    
    Scaffold(topBar = { CustomTopBar(title = "Suivi de demande", onNavigationClick = null, showBackground = true) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                EVIsaCard {
                    Text("Suivre votre demande", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Entrez votre numéro de demande", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item { EVIsaTextField(value = trackingNumber, onValueChange = { trackingNumber = it }, label = "Numéro de demande", placeholder = "Ex: BF2026XXXXXX") }
            item { PrimaryButton("Rechercher", onClick = { isSearching = true }, enabled = trackingNumber.isNotEmpty()) }
            if (isSearching && trackingNumber.isNotEmpty()) {
                item {
                    EVIsaCard {
                        Text("Statut de la demande", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(8.dp))
                        StatusRow("Numéro", trackingNumber)
                        StatusRow("Date", "11/01/2026")
                        StatusRow("Statut", "En traitement")
                        StatusRow("Délai", "3-5 jours")
                    }
                }
                item {
                    EVIsaCard {
                        Text("Étapes du traitement", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(8.dp))
                        TrackStep("Demande reçue", true, true)
                        TrackStep("Vérification", true, false)
                        TrackStep("Traitement", false, false)
                        TrackStep("Décision", false, false)
                    }
                }
            }
        }
    }
}

@Composable
fun StatusRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("$label:", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun TrackStep(title: String, completed: Boolean, inProgress: Boolean) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = if (completed) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
            contentDescription = null,
            tint = if (completed || inProgress) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(end = 12.dp).size(24.dp)
        )
        Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = if (completed || inProgress) FontWeight.Medium else FontWeight.Normal, color = if (completed || inProgress) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

// Contact
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController) {
    Scaffold(topBar = { CustomTopBar(title = "Contact", onNavigationClick = null, showBackground = true, backgroundImage = R.drawable.contact) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                EVIsaCard {
                    Text("Division de la Migration", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Direction Générale de la Police Nationale", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item { EVIsaCard { ContactItem(Icons.Default.LocationOn, "Adresse", "Avenue de l'Indépendance\nOuagadougou, Burkina Faso") } }
            item { EVIsaCard { ContactItem(Icons.Default.Phone, "Téléphone", "(+226) 70 84 68 60\n(+226) 53 97 76 61") } }
            item { EVIsaCard { ContactItem(Icons.Default.Email, "Email", "contact@visaburkina.bf") } }
            item { EVIsaCard { ContactItem(Icons.Default.Info, "Horaires", "Lundi - Vendredi: 08h00 - 16h00\nSamedi - Dimanche: Fermé") } }
        }
    }
}

@Composable
fun ContactItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, content: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(end = 16.dp, top = 4.dp))
        Column {
            Text(title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(content, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

// Profil
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(topBar = { CustomTopBar(title = "Profil", onNavigationClick = null, showBackground = true) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                EVIsaCard {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Person, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(end = 16.dp).size(48.dp))
                        Column {
                            Text("Utilisateur", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                            Text("utilisateur@email.com", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
            item { Text("Mes demandes", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold) }
            item { EVIsaCard { AppHistoryItem("BF2026001234", "11/01/2026", "En traitement") } }
            item { EVIsaCard { AppHistoryItem("BF2025009876", "15/12/2025", "Approuvée") } }
            item { Text("Paramètres", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold) }
            item { EVIsaCard { SettItem("Notifications") } }
            item { EVIsaCard { SettItem("Langue") } }
            item { EVIsaCard { SettItem("Aide et support") } }
            item { SecondaryButton("Se déconnecter", onClick = { }) }
        }
    }
}

@Composable
fun AppHistoryItem(number: String, date: String, status: String) {
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(number, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
            Text(status, style = MaterialTheme.typography.labelMedium, color = when (status) { "Approuvée" -> MaterialTheme.colorScheme.primary; "En traitement" -> MaterialTheme.colorScheme.tertiary; else -> MaterialTheme.colorScheme.error })
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text("Date: $date", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
fun SettItem(title: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Icon(Icons.AutoMirrored.Filled.ArrowForward, null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

// Paiement
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    Scaffold(topBar = { CustomTopBar(title = "Paiement", onNavigationClick = { navController.navigateUp() }) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                EVIsaCard {
                    Text("Récapitulatif", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(12.dp))
                    PayRow("Frais de visa", "50 000 FCFA")
                    PayRow("Frais de traitement", "5 000 FCFA")
                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(8.dp))
                    PayRow("Total", "55 000 FCFA", true)
                }
            }
            item { Text("Mode de paiement", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold) }
            item { EVIsaCard { PayMethodItem("Mobile Money") } }
            item { EVIsaCard { PayMethodItem("Carte bancaire") } }
            item { EVIsaCard { PayMethodItem("Virement bancaire") } }
            item { PrimaryButton("Procéder au paiement", onClick = { navController.navigateUp() }) }
            item {
                EVIsaCard {
                    Text("Paiement sécurisé", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Toutes les transactions sont cryptées", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}

@Composable
fun PayRow(label: String, amount: String, isTotal: Boolean = false) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, style = if (isTotal) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium, fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal)
        Text(amount, style = if (isTotal) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium, fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal, color = if (isTotal) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun PayMethodItem(method: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(method, style = MaterialTheme.typography.bodyLarge)
        Icon(Icons.AutoMirrored.Filled.ArrowForward, null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

// À propos
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(topBar = { CustomTopBar(title = "À propos", onNavigationClick = { navController.navigateUp() }) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                EVIsaCard {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                        Text("eVisa Burkina Faso", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Version 1.0.0", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
            item {
                EVIsaCard {
                    Text("À propos", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Application officielle du Ministère de la Sécurité du Burkina Faso pour les demandes de visa électronique.", style = MaterialTheme.typography.bodyMedium)
                }
            }
            item {
                EVIsaCard {
                    Text("Fonctionnalités", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))
                    FeatureItem("Demande de visa en ligne")
                    FeatureItem("Suivi en temps réel")
                    FeatureItem("Paiement sécurisé")
                    FeatureItem("Support multilingue")
                }
            }
            item {
                EVIsaCard {
                    Text("Informations légales", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("© 2026 Ministère de la Sécurité\nTous droits réservés", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun FeatureItem(text: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.CheckCircle, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(end = 8.dp).size(20.dp))
        Text(text, style = MaterialTheme.typography.bodyMedium)
    }
}
