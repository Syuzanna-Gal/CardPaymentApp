package com.example.cardpaymentapp.domain.usecases

import com.example.cardpaymentapp.data.AppRepo
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.PayCardResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class PayWithCardUseCase(val appRepo: AppRepo) {
    fun payWithCard(card: CardModel): Flow<PayCardResponse> {
        //TODO call to Repo if there is any API
        //Now we do imitation of call
        //card balance
        when {
            card.balance <= 0 -> return flow { PayCardResponse(error = "Not enough methods found") }
            card.balance in 1..900 -> return flow { PayCardResponse(error = "Transition can't be less then 1000") }
            card.balance > 1000 -> return flow { PayCardResponse(success = "Payed successfully") }
        }
        //TODO other cases
        //valid card
        val currentYear = Calendar.getInstance().get(Calendar.YEAR).toString()
        return flow { PayCardResponse("") }
    }
}