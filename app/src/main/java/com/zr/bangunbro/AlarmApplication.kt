package com.zr.bangunbro

import android.app.Application
import com.zr.bangunbro.di.appModule
import com.zr.bangunbro.di.useCaseModule
import com.zr.bangunbro.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AlarmApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AlarmApplication)
            modules(appModule, useCaseModule, viewModelModule)
        }
    }
}