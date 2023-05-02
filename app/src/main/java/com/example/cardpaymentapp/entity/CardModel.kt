package com.example.cardpaymentapp.entity

import com.example.cardpaymentapp.entity.enums.CardType

data class CardModel(
    val id: Int,
    val name: String,
    val type: CardType,
    val balance: Int,
    val validUntil: String
) {
    companion object{
        const val SUCCESS_CARD_ID = 1
        const val ERROR_CARD_ID = 2
        const val NOT_ENOUGH_BALANCE_CARD_ID = 3
    }
}