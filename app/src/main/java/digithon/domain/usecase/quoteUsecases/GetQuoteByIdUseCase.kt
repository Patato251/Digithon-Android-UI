package digithon.domain.usecase.quoteUsecases

import digithon.domain.model.Quote
import digithon.domain.repository.QuoteRepository
import javax.inject.Inject

class GetQuoteByIdUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(quoteId: String): Quote? {
        return repository.getQuoteById(quoteId = quoteId)
    }
}