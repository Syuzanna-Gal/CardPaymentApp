package com.example.cardpaymentapp.data

import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import kotlinx.coroutines.flow.Flow

interface AppRepo {
    fun payWithCard(card: CardModel): Flow<PayCardResponse>
}