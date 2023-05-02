package com.example.cardpaymentapp.presentation.di

import com.example.cardpaymentapp.presentation.fragment.CardsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::CardsViewModel)
}