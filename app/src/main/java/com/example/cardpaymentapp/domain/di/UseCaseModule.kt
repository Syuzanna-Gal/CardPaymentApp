package com.example.cardpaymentapp.domain.di

import com.example.cardpaymentapp.domain.usecases.GetCardsUseCase
import com.example.cardpaymentapp.domain.usecases.PayWithCardUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetCardsUseCase() }
    factory { PayWithCardUseCase(get()) }
}