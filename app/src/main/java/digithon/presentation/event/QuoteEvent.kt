package digithon.presentation.event

sealed class QuoteEvent {
    data class EnteredTitle(val value: String): QuoteEvent()
    data class EnteredFirstName(val value: String): QuoteEvent()
    data class EnteredSurname(val value: String): QuoteEvent()
    data class EnteredDate(val value: String): QuoteEvent()
    data class EnteredInsurer(val value: String): QuoteEvent()
    object SaveQuote: QuoteEvent()


}
