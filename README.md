# eVisa Burkina Faso - Application Mobile

Application Android native pour faciliter les demandes de visa électronique pour le Burkina Faso. Développée dans le cadre du projet d'application mobile Android.

## À propos du projet

Cette application permet aux utilisateurs de faire leur demande de visa burkinabè directement depuis leur smartphone. Elle reproduit les fonctionnalités du site officiel [visaburkina.bf](https://www.visaburkina.bf) en offrant une meilleure expérience mobile.

J'ai essayé de créer une interface simple et intuitive, avec les couleurs du drapeau burkinabè pour que l'application soit immédiatement reconnaissable.

## Fonctionnalités principales

### 🏠 Page d'accueil
- Bannière avec le Monument de l'Indépendance de Ouagadougou
- Présentation des 4 étapes du processus de demande
- Liste des types de visas disponibles (Transit, Court séjour, Long séjour)
- Conditions d'obtention
- Liens utiles et événements

### 📝 Demande de visa
Formulaire complet en 4 sections :
- **Infos** : Informations personnelles (nationalité, email, téléphone)
- **Passeport** : Détails du passeport (numéro, dates de validité)
- **Voyage** : Informations sur le séjour (dates, motif, hébergement)
- **Documents** : Upload des pièces justificatives

### 🔍 Suivi de demande
Permet de suivre l'état d'avancement d'une demande avec le numéro de dossier.

### 💳 Paiement
Section pour le paiement des frais de visa (fonctionnalité à venir).

### 👤 Profil
- Informations de l'utilisateur
- Historique des demandes
- Paramètres (notifications, langue)

### 📞 Contact
Coordonnées complètes de la Division de la Migration :
- Adresse : Avenue de l'Indépendance, Ouagadougou
- Téléphones : (+226) 70 84 68 60 / 53 97 76 61
- Email : contact@visaburkina.bf
- Horaires d'ouverture

### ℹ️ À propos
Informations sur l'application et la Direction Générale de la Police Nationale.

## Stack technique

- **Langage** : Kotlin
- **UI** : Jetpack Compose (Material Design 3)
- **Navigation** : Navigation Compose
- **Architecture** : MVVM (préparé pour évolution future)
- **Versions** :
  - minSdk : 24 (Android 7.0)
  - targetSdk : 36 (Android 15)
  - Kotlin : 2.1.0

## Design

L'application utilise les couleurs du drapeau burkinabè :
- **Vert** (#009639) : Couleur principale
- **Rouge** (#EF2917) : Couleur secondaire  
- **Jaune** (#FCD116) : Couleur d'accent

Les headers de certains écrans ont des images de fond personnalisées (passeport, contact) pour rendre l'interface plus vivante.

## Installation

### Prérequis
- Android Studio Ladybug ou supérieur
- JDK 11
- Appareil Android 7.0+ ou émulateur

### Étapes
1. Cloner le repository :
```bash
git clone https://github.com/OUEDRAOGOFred/Projet_e-visa.git
```

2. Ouvrir le projet dans Android Studio

3. Laisser Gradle synchroniser les dépendances

4. Lancer l'application :
   - Sur émulateur : Cliquer sur Run
   - Sur appareil physique : Activer le mode développeur et connecter via USB

## Structure du projet

```
app/src/main/java/com/example/projet_e_visa_s7iiaa/
├── MainActivity.kt                 # Point d'entrée
├── models/
│   └── VisaApplication.kt         # Modèles de données
├── navigation/
│   ├── AppNavigation.kt           # Configuration de la navigation
│   ├── BottomNavItem.kt           # Items de la barre inférieure
│   └── Screen.kt                  # Routes
├── screens/
│   ├── HomeScreen.kt              # Écran d'accueil
│   ├── AllScreens.kt              # Tous les autres écrans
│   └── SplashScreen.kt            # Écran de démarrage (optionnel)
├── ui/
│   ├── components/                # Composants réutilisables
│   │   ├── Buttons.kt
│   │   ├── Cards.kt
│   │   ├── TextFields.kt
│   │   └── TopBars.kt
│   └── theme/                     # Thème de l'application
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
```

## Améliorations futures

- [ ] Intégration d'une vraie API backend
- [ ] Système d'authentification complet
- [ ] Upload réel de documents
- [ ] Intégration de moyens de paiement (Mobile Money)
- [ ] Notifications push pour le suivi
- [ ] Support multilingue (Français, Anglais, Mooré)
- [ ] Mode hors ligne avec synchronisation

## Difficultés rencontrées

Pendant le développement, j'ai eu quelques galères notamment :
- La gestion des images de fond dans les TopBars (fallait bien gérer la transparence)
- L'alignement des tabs qui cassait sur certains écrans
- Trouver les bonnes photos pour illustrer l'application

Mais dans l'ensemble ça s'est plutôt bien passé. Compose est vraiment puissant une fois qu'on maîtrise les bases.

## Auteur

**Freddy OUEDRAOGO**  
Étudiant S7 IIAA  
Projet de développement d'applications mobiles

## Licence

Ce projet est développé dans un cadre pédagogique. Pour toute réutilisation, merci de contacter l'auteur.

## Remerciements

- Direction Générale de la Police Nationale du Burkina Faso pour l'inspiration
- Professeurs et encadreurs du projet
- Communauté Android/Kotlin pour la documentation

---

*Dernière mise à jour : Janvier 2026*
