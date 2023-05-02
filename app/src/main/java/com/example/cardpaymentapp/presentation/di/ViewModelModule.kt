package com.example.cardpaymentapp.presentation.di

import com.example.cardpaymentapp.presentation.cardsFragment.CardsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CardsViewModel(get()) }
}