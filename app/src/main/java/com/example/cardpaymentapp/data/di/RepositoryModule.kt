package com.example.cardpaymentapp.data.di

import com.example.cardpaymentapp.data.AppRepo
import com.example.cardpaymentapp.data.AppRepoImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AppRepo> { AppRepoImpl() }
}