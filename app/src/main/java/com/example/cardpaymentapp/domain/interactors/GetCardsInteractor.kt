package com.example.cardpaymentapp.domain.interactors

import com.example.cardpaymentapp.entity.CardModel
import kotlinx.coroutines.flow.Flow

interface GetCardsInteractor {
    fun getCards(): Flow<List<CardModel>>
}