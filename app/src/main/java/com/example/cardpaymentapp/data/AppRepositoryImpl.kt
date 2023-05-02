package com.example.cardpaymentapp.data

import com.example.cardpaymentapp.domain.repository.AppRepository
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import com.example.cardpaymentapp.entity.enums.CardType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl : AppRepository {
    companion object {
        private val cardsList = listOf(
            CardModel(
                id = CardModel.SUCCESS_CARD_ID,
                name = "First card",
                balance = 2000,
                type = CardType.MASTER,
                validUntil = "17/25"
            ),
            CardModel(
                id = CardModel.NOT_ENOUGH_BALANCE_CARD_ID,
                name = "Second card",
                balance = 0,
                type = CardType.VISA,
                validUntil = "17/24"
            ),
            CardModel(
                id = CardModel.ERROR_CARD_ID,
                name = "Third card",
                balance = 2000,
                type = CardType.MASTER,
                validUntil = "17/26"
            ),
        )
    }

    override fun getCards(): Flow<List<CardModel>> = flow {
        emit(cardsList)
    }

    override fun payWithCard(card: CardModel): Flow<PayCardResponse> = flow {
        when (card.id) {
            CardModel.SUCCESS_CARD_ID -> emit(PayCardResponse(successMessage = "Payed successfully"))
            CardModel.ERROR_CARD_ID -> throw RuntimeException("Something went wrong")
            CardModel.NOT_ENOUGH_BALANCE_CARD_ID -> throw RuntimeException("Not enough balance")
            else -> throw RuntimeException("Unknown card")
        }
    }
}