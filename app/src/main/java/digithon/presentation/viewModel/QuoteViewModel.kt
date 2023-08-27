package digithon.presentation.viewModel

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import digithon.domain.model.InvalidQuoteException
import digithon.domain.model.Quote
import digithon.domain.usecase.quoteUsecases.QuoteUseCases
import digithon.presentation.event.QuoteEvent
import digithon.presentation.util.stateModels.QuoteUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val quoteUseCases: QuoteUseCases
) : ViewModel() {

    private val errorList = listOf("Mr.", "Mrs.", "Miss", "Ms.", "Dr.", "Sir")

    private val _uiState = MutableStateFlow(QuoteUiState())
    val uiState: StateFlow<QuoteUiState> = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: QuoteEvent) {
        when(event) {
            is QuoteEvent.EnteredTitle -> {
                val errors = mutableListOf<String>()
                if (!errorList.contains(event.value)) {
                    errors.add("Please enter a valid title")
                }
                _uiState.value = uiState.value.copy(
                    title = event.value,
                    titleErrors = errors
                )
            }
            is QuoteEvent.EnteredFirstName -> {
                val errors = mutableListOf<String>()
                if (event.value.isEmpty()) {
                    errors.add("Please enter a valid first name")
                }
                _uiState.value = uiState.value.copy(
                    firstName = event.value,
                    firstNameErrors = errors
                )
            }
            is QuoteEvent.EnteredSurname -> {
                val errors = mutableListOf<String>()
                if (event.value.isEmpty()) {
                    errors.add("Please enter a valid surname")
                }
                _uiState.value = uiState.value.copy(
                    surname = event.value,
                    surnameErrors = errors
                )
            }
            is QuoteEvent.EnteredInsurer -> {
                _uiState.value = uiState.value.copy(
                    recentInsurer = event.value
                )
            }
            is QuoteEvent.EnteredDate -> {
                _uiState.value = uiState.value.copy(
                    policyStartDate = event.value.toLong()
                )
            }
            is QuoteEvent.SaveQuote -> {
                viewModelScope.launch {
                    try {
                        quoteUseCases.addQuoteUseCase(
                            Quote(
                                title = _uiState.value.title,
                                firstName = _uiState.value.firstName,
                                surname = _uiState.value.surname,
                                recentInsurer = _uiState.value.recentInsurer,
                                policyStartDate = _uiState.value.policyStartDate,
                                dateCreated = _uiState.value.dateCreated,
                                quoteId = "QTE" + (1000..9999).random().toString()
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveQuote)
                    } catch(error: InvalidQuoteException) {
                        //TODO: Implement some error handling for fail save quote
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveQuote: UiEvent()
    }

}