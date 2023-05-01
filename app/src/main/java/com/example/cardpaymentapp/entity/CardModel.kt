package com.example.cardpaymentapp.entity

import com.example.cardpaymentapp.entity.enums.CardType
import java.util.*

data class CardModel(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val type: CardType,
    val balance: Long,
    val validUntil: String
)