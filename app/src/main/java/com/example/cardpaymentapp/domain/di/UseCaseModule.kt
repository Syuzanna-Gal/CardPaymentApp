package com.example.cardpaymentapp.domain.di

import com.example.cardpaymentapp.domain.usecases.GetCardsUseCase
import com.example.cardpaymentapp.domain.usecases.PayWithCardUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCasesModule = module {
    factoryOf(::GetCardsUseCase)
    factoryOf(::PayWithCardUseCase)
}