package com.example.carwashing

import android.app.Application
import android.content.res.Configuration
import android.content.res.Resources
import com.example.carwashing.di.appModule
import com.example.carwashing.di.authModule
import com.example.carwashing.di.mainModule
import com.example.carwashing.di.networkingModule
import org.koin.android.ext.android.startKoin
import java.util.logging.Logger


class Jumaisynba : Application() {

    override fun onCreate() {
        super.onCreate()

//        Fresco.initialize(this)
//
//        AppCenter.start(
//
//            AppCenter.start(      this, "4cc3e622-1a44-4f56-8577-e2e639fc60ae",
//            Analytics::class.java, Crashes::class.java
//        )
        //val enableCrashAndAnalytics = !BuildConfig.DEBUG
        //Crashes.setEnabled(enableCrashAndAnalytics)
        //Analytics.setEnabled(enableCrashAndAnalytics)

        //Logger.addLogAdapter(AndroidLogAdapter())
        startKoin(this, listOf(appModule, mainModule))
    }
}