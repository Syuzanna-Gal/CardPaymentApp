package com.example.cardpaymentapp.presentation

import android.app.Application
import com.example.cardpaymentapp.BuildConfig
import com.example.cardpaymentapp.data.di.repositoryModule
import com.example.cardpaymentapp.domain.di.useCasesModule
import com.example.cardpaymentapp.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(modules)
        }
    }

    private val modules = listOf(
        viewModelModule,
        repositoryModule,
        useCasesModule
    )
}