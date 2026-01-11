package com.example.projet_e_visa_s7iiaa.models

data class VisaApplication(
    val applicationNumber: String = "",
    val personalInfo: PersonalInfo = PersonalInfo(),
    val passportInfo: PassportInfo = PassportInfo(),
    val travelInfo: TravelInfo = TravelInfo(),
    val status: ApplicationStatus = ApplicationStatus.DRAFT,
    val submissionDate: String = ""
)

data class PersonalInfo(
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val nationality: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val address: String = "",
    val city: String = "",
    val country: String = ""
)

data class PassportInfo(
    val passportNumber: String = "",
    val issueDate: String = "",
    val expiryDate: String = "",
    val placeOfIssue: String = ""
)

data class TravelInfo(
    val arrivalDate: String = "",
    val departureDate: String = "",
    val purposeOfVisit: String = "",
    val accommodationAddress: String = "",
    val visaType: VisaType = VisaType.TOURIST
)

enum class VisaType(val displayName: String) {
    TRANSIT("Visa de transit"),
    SHORT_STAY("Visa de courte durée"),
    LONG_STAY("Visa de longue durée"),
    TOURIST("Tourisme"),
    BUSINESS("Affaires")
}

enum class ApplicationStatus(val displayName: String) {
    DRAFT("Brouillon"),
    SUBMITTED("Soumise"),
    PROCESSING("En traitement"),
    APPROVED("Approuvée"),
    REJECTED("Rejetée"),
    EXPIRED("Expirée")
}
