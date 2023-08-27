package digithon.domain.usecase.quoteUsecases

data class QuoteUseCases(
    val getQuotesUseCase: GetQuotesUseCase,
    val deleteQuoteUseCase: DeleteQuoteUseCase,
    val addQuoteUseCase: AddQuoteUseCase,
    val getQuoteByIdUseCase: GetQuoteByIdUseCase,
)
