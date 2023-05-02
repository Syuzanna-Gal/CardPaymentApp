package com.example.cardpaymentapp.entity

import com.example.cardpaymentapp.entity.enums.CardType

data class CardModel(
    val id: Int,
    val name: String,
    val type: CardType,
    var balance: Int,
    val validUntil: String
) {
    companion object{
        const val SUCCESS_CARD_ID_1 = 0
        const val ERROR_CARD_ID = 1
        const val SUCCESS_CARD_ID_2 = 2
    }
}