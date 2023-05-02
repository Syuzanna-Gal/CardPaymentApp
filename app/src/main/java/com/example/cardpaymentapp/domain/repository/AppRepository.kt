package com.example.cardpaymentapp.domain.repository

import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getCards(): Flow<List<CardModel>>

    fun payWithCard(card: CardModel): Flow<PayCardResponse>
}