package digithon.presentation.util.stateModels

data class QuoteUiState constructor(
    val dateCreated: Long = System.currentTimeMillis(),
    val quoteId: String? = "",
    val policyStartDate: Long = System.currentTimeMillis(),
    val title: String = "",
    val firstName: String = "",
    val surname: String = "",
    val recentInsurer: String = "",
    val titleErrors: MutableList<String> = mutableListOf(),
    val firstNameErrors: MutableList<String> = mutableListOf(),
    val surnameErrors: MutableList<String> = mutableListOf(),
    )
