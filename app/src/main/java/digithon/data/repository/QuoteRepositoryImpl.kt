package digithon.data.repository

import digithon.data.database.QuoteDao
import digithon.domain.model.Quote
import digithon.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteDao: QuoteDao
) : QuoteRepository {
    override fun getNotes(): Flow<List<Quote>> {
        return quoteDao.getQuotes()
    }

    override suspend fun getQuoteById(quoteId: String): Quote? {
        return quoteDao.getQuoteById(quoteId = quoteId)
    }

    override suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote = quote)
    }

    override suspend fun deleteQuote(quote: Quote) {
        quoteDao.deleteQuote(quote = quote)
    }
}