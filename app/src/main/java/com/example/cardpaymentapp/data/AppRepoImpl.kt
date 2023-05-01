package com.example.cardpaymentapp.data

import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepoImpl: AppRepo {
    override fun payWithCard(card: CardModel): Flow<PayCardResponse> = flow {
        //TODO call if there is any API
    }
}