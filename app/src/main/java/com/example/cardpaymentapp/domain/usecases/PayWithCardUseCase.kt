package com.example.cardpaymentapp.domain.usecases

import com.example.cardpaymentapp.domain.repository.AppRepository
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import kotlinx.coroutines.flow.Flow

class PayWithCardUseCase(private val repository: AppRepository) {
    operator fun invoke(card: CardModel): Flow<PayCardResponse> = repository.payWithCard(card)
}