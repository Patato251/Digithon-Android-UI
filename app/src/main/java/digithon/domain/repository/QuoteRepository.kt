package digithon.domain.repository

import digithon.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getNotes(): Flow<List<Quote>>
    suspend fun getQuoteById(quoteId: String): Quote?
    suspend fun insertQuote(quote: Quote)
    suspend fun deleteQuote(quote: Quote)
}