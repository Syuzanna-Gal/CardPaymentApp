package com.example.cardpaymentapp.domain.usecases

import com.example.cardpaymentapp.domain.repository.AppRepository
import com.example.cardpaymentapp.entity.CardModel
import kotlinx.coroutines.flow.Flow

class GetCardsUseCase(private val repository: AppRepository) {
    operator fun invoke(): Flow<List<CardModel>> = repository.getCards()
}