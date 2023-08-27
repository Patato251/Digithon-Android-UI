package digithon.domain.util

sealed class QuoteOrder(val orderType: OrderType) {
    class QuoteId(orderType: OrderType): QuoteOrder(orderType)
    class DateCreated(orderType: OrderType): QuoteOrder(orderType)

    fun copy(orderType: OrderType): QuoteOrder {
        return when (this) {
            is QuoteId -> QuoteId(orderType)
            is DateCreated -> DateCreated(orderType)
        }
    }
}
