package com.example.cardpaymentapp.data.di

import com.example.cardpaymentapp.data.AppRepositoryImpl
import com.example.cardpaymentapp.domain.repository.AppRepository
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::AppRepositoryImpl) { bind<AppRepository>() }
}