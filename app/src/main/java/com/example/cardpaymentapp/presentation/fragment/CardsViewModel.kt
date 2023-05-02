package com.example.cardpaymentapp.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardpaymentapp.domain.usecases.GetCardsUseCase
import com.example.cardpaymentapp.entity.CardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class CardsViewModel(private val getCardsUseCase: GetCardsUseCase) : ViewModel() {

    private val _cardsList = MutableStateFlow<List<CardModel>?>(null)
    val cardsList = _cardsList.asStateFlow()

    fun getCards() = getCardsUseCase()
        .flowOn(Dispatchers.IO)
        .onEach {
            _cardsList.value = it
        }
        .catch {
            // TODO: error
        }
        .launchIn(viewModelScope)
}
