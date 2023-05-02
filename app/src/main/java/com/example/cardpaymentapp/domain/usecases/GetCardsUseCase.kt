package com.example.cardpaymentapp.domain.usecases

import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.enums.CardType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetCardsUseCase {
    fun getCards(): Flow<List<CardModel>> {
        val cardsList = mutableListOf<CardModel>()
        cardsList.add(
            CardModel(
                name = "First card",
                balance = 2000,
                type = CardType.MASTER,
                validUntil = "17/25"
            ),
        )
        cardsList.add(
            CardModel(
                name = "Second card",
                balance = 0,
                type = CardType.VISA,
                validUntil = "17/24"
            ),
        )
        cardsList.add(
            CardModel(
                name = "Third card",
                balance = 2000,
                type = CardType.MASTER,
                validUntil = "17/20"
            ),
        )
        return flowOf(cardsList)
    }
}