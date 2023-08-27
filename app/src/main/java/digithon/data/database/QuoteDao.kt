package digithon.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import digithon.domain.model.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuotes(): Flow<List<Quote>>

    // Suspend fun since we are returning direct value
    @Query("SELECT * FROM quote WHERE quoteId = :quoteId")
    suspend fun getQuoteById(quoteId: String?): Quote?

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertQuote(quote: Quote)

    @Delete
    suspend fun deleteQuote(quote: Quote)
}