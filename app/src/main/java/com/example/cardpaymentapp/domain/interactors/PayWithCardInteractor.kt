package com.example.cardpaymentapp.domain.interactors

import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import kotlinx.coroutines.flow.Flow

interface PayWithCardInteractor {
    fun payWithCard(card: CardModel): Flow<PayCardResponse>
}