package com.example.cardpaymentapp.domain.usecases

import com.example.cardpaymentapp.domain.repository.AppRepository
import com.example.cardpaymentapp.entity.CardModel

class GetCardsUseCase(private val repository: AppRepository) {
    operator fun invoke(): List<CardModel> = repository.getCards()
}