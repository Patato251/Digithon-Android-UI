package digithon.data.repository

import digithon.data.local.database.QuoteDao
import digithon.domain.model.Quote
import digithon.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteDao: QuoteDao
) : QuoteRepository {

    override val quotes: Flow<List<String>> =
        quoteDao.getQuotes().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        quoteDao.insertQuote(Quote(name = name))
    }
}