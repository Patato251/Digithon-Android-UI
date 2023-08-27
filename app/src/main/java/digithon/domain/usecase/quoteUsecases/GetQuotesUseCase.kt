package digithon.domain.usecase.quoteUsecases

import digithon.domain.model.Quote
import digithon.domain.repository.QuoteRepository
import digithon.domain.util.OrderType
import digithon.domain.util.QuoteOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(
        quoteOrder: QuoteOrder = QuoteOrder.QuoteId(OrderType.Ascending)
    ): Flow<List<Quote>> {
        return repository.getNotes().map { quotes ->
            when (quoteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (quoteOrder) {
                        is QuoteOrder.QuoteId -> quotes.sortedBy { it.quoteId?.lowercase() }
                        is QuoteOrder.DateCreated -> quotes.sortedBy { it.dateCreated }
                    }
                }

                is OrderType.Descending -> {
                    when (quoteOrder) {
                        is QuoteOrder.QuoteId -> quotes.sortedByDescending { it.quoteId?.lowercase() }
                        is QuoteOrder.DateCreated -> quotes.sortedByDescending { it.dateCreated }
                    }
                }
            }
        }
    }
}