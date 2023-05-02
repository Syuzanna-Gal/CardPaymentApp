package com.example.cardpaymentapp.data

import com.example.cardpaymentapp.domain.repository.AppRepository
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import com.example.cardpaymentapp.entity.enums.CardType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl : AppRepository {

    companion object {
        private val cardsList = mutableListOf(
            CardModel(
                id = CardModel.SUCCESS_CARD_ID_1,
                name = "First card",
                balance = 2000,
                type = CardType.MASTER,
                validUntil = "17/25"
            ),
            CardModel(
                id = CardModel.SUCCESS_CARD_ID_2,
                name = "Second card",
                balance = 0,
                type = CardType.VISA,
                validUntil = "17/24"
            ),
            CardModel(
                id = CardModel.ERROR_CARD_ID,
                name = "Third card",
                balance = 6000,
                type = CardType.MASTER,
                validUntil = "17/20"
            ),
        )
    }

    override fun getCards(): List<CardModel> = cardsList

    override fun payWithCard(cardId: Int, paymentAmount: Int): Flow<PayCardResponse> = flow {
        val cardIndex = cardsList.indexOfFirst { it.id == cardId }
        if (cardIndex < 0)
            throw RuntimeException("Unknown card")
        val selectedCard = cardsList[cardIndex]
        when (cardId) {
            CardModel.SUCCESS_CARD_ID_1, CardModel.SUCCESS_CARD_ID_2 -> {
                if (selectedCard.balance < paymentAmount) {
                    throw RuntimeException("Not enough balance")
                }
                selectedCard.balance = selectedCard.balance - paymentAmount
                cardsList[cardIndex] = selectedCard
                emit(PayCardResponse(successMessage = "Payed successfully"))
            }
            CardModel.ERROR_CARD_ID -> throw RuntimeException("Something went wrong")
            else -> throw RuntimeException("Unknown card")
        }
    }
}