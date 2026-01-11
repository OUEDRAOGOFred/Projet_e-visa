package com.example.projet_e_visa_s7iiaa.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projet_e_visa_s7iiaa.R
import com.example.projet_e_visa_s7iiaa.navigation.Screen
import com.example.projet_e_visa_s7iiaa.ui.components.EVIsaCard
import com.example.projet_e_visa_s7iiaa.ui.components.PrimaryButton

@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Bannière avec le Monument de l'Indépendance
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Image du monument
                    Image(
                        painter = painterResource(id = R.drawable.monument_ouaga),
                        contentDescription = "Monument de l'Indépendance, Ouagadougou",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    
                    // Overlay avec gradient
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.3f),
                                        Color.Black.copy(alpha = 0.6f)
                                    )
                                )
                            )
                    )
                    
                    // Texte superposé
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Bienvenue au",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            text = "Burkina Faso",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "eVisa - Demande en ligne",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .background(
                                    Color.White,
                                    RoundedCornerShape(16.dp)
                                )
                                .padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }
        
        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        item {
            EVIsaCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Procédure eVisa",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Complétez votre demande en 3 étapes simples",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        item {
            ProcessStepCard(
                stepNumber = "1",
                title = "Remplir le formulaire de demande",
                description = "Fournissez vos informations personnelles et de voyage",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            ProcessStepCard(
                stepNumber = "2",
                title = "Payer les frais de visa",
                description = "Effectuez le paiement en ligne de manière sécurisée",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            ProcessStepCard(
                stepNumber = "3",
                title = "Obtenir la décision",
                description = "Recevez votre visa électronique par email",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            ProcessStepCard(
                stepNumber = "4",
                title = "Voyager au Burkina Faso",
                description = "Présentez votre eVisa à l'arrivée au Burkina Faso",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        item {
            Text(
                text = "Types de visas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            EVIsaCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    VisaTypeItem(
                        "Le visa de transit",
                        "Valable pour un séjour de 5 jours maximum. Destiné aux voyageurs en transit vers une autre destination."
                    )
                    VisaTypeItem(
                        "Le visa de courte durée",
                        "Valable pour un séjour de 1 à 90 jours. Idéal pour le tourisme, les affaires ou les visites familiales."
                    )
                    VisaTypeItem(
                        "Le visa de longue durée",
                        "Valable pour un séjour de plus de 90 jours. Requis pour le travail, les études ou l'installation."
                    )
                }
            }
        }
        
        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        item {
            Text(
                text = "Conditions",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            EVIsaCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    ConditionItem(
                        "Documents requis",
                        "Passeport valide (6 mois minimum), photo d'identité récente, justificatif d'hébergement"
                    )
                    ConditionItem(
                        "Délai de traitement",
                        "3 à 5 jours ouvrables après soumission du dossier complet"
                    )
                    ConditionItem(
                        "Validité",
                        "Le visa est valable à partir de la date d'émission selon le type choisi"
                    )
                    ConditionItem(
                        "Paiement",
                        "Paiement en ligne sécurisé par carte bancaire ou Mobile Money"
                    )
                }
            }
        }
        
        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        item {
            PrimaryButton(
                text = "Commencer une demande",
                onClick = { navController.navigate(Screen.VisaApplication.route) },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            EVIsaCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "À propos du eVisa",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "L'eVisa est un protocole qui certifie que le titulaire est autorisé à entrer et séjourner au Burkina Faso pour une durée maximale de 90 jours.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        item {
            Text(
                text = "Liens Utiles",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            EVIsaCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    UsefulLinkItem("Présidence du Faso", "presidencedufaso.bf")
                    UsefulLinkItem("Primature", "gouvernement.gov.bf")
                    UsefulLinkItem("Ministère de la Sécurité", "securite.gov.bf")
                    UsefulLinkItem("Ministère des Affaires Étrangères", "mae.gov.bf")
                    UsefulLinkItem("Ministère des Finances", "finances.gov.bf")
                    UsefulLinkItem("Ministère de la Culture", "culture.gov.bf")
                }
            }
        }
        
        item {
            Text(
                text = "Événements",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            EVIsaCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    EventItem("SIAO", "Salon International de l'Artisanat de Ouagadougou")
                    EventItem("FESPACO", "Festival Panafricain du Cinéma et de la Télévision")
                    EventItem("SAMAO", "Salon des Mines et de l'Artisanat de l'Ouest")
                }
            }
        }
    }
}

@Composable
fun ProcessStepCard(
    stepNumber: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    EVIsaCard(modifier = modifier) {
        Column {
            Text(
                text = "Étape $stepNumber",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun UsefulLinkItem(title: String, url: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = url,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun EventItem(name: String, description: String) {
    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun VisaTypeItem(title: String, description: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ConditionItem(title: String, description: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
