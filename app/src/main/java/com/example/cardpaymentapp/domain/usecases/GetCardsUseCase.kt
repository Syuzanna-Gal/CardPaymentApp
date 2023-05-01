package com.example.cardpaymentapp.domain.usecases

import com.example.cardpaymentapp.domain.interactors.GetCardsInteractor
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.enums.CardType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

//TODO
class GetCardsUseCase : GetCardsInteractor {
    override fun getCards(): Flow<List<CardModel>> {
        val cardsList = mutableListOf<CardModel>()
        cardsList.add(
            CardModel(
                name = "First card",
                balance = 2000L,
                type = CardType.MASTER,
                validUntil = "17/25"
            )
        )
        return flowOf(cardsList)
    }
}