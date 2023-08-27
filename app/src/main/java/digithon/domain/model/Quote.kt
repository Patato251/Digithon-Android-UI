package digithon.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val dateCreated: Long,
    val quoteId: String?,
    val policyStartDate: Long,
    val title: String,
    val firstName: String,
    val surname: String,
    val recentInsurer: String,
)

class InvalidQuoteException(message: String): Exception(message)
