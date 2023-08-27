package digithon.domain.usecase.quoteUsecases

import digithon.domain.model.Quote
import digithon.domain.repository.QuoteRepository
import javax.inject.Inject

class AddQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(quote: Quote) {
        repository.insertQuote(quote)
    }
}