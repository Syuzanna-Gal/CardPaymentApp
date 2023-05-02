package com.example.cardpaymentapp.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardpaymentapp.domain.usecases.GetCardsUseCase
import com.example.cardpaymentapp.domain.usecases.PayWithCardUseCase
import com.example.cardpaymentapp.entity.CardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CardsViewModel(
    private val getCardsUseCase: GetCardsUseCase,
    private val payWithCardUseCase: PayWithCardUseCase
) : ViewModel() {

    private val _cardsList = Channel<List<CardModel>>(Channel.BUFFERED)
    val cardsList = _cardsList.receiveAsFlow()

    private val _showError = Channel<String>(Channel.BUFFERED)
    val showError = _showError.receiveAsFlow()

    private val _showSuccess = MutableSharedFlow<String>()
    val showSuccess = _showSuccess.asSharedFlow()

    init {
        getCards()
    }

    fun payWithCard(
        card: CardModel,
        paymentAmount: Int
    ) = payWithCardUseCase.invoke(card, paymentAmount)
        .flowOn(Dispatchers.IO)
        .onEach {
            _showSuccess.emit(it.successMessage)
            getCards()
        }
        .catch { error ->
            error.message?.let {
                _showError.send(it)
            }
        }
        .launchIn(viewModelScope)

    private fun getCards() {
        viewModelScope.launch {
            _cardsList.send(getCardsUseCase())
        }
    }
}
