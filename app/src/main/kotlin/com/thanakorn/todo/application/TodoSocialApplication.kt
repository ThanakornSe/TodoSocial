package com.thanakorn.todo.application

import android.app.Application
import com.thanakorn.todo.BuildConfig
import com.thanakorn.todo.common.base.AppConfiguration
import com.thanakorn.todo.feature.main.di.mainFeatureModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class TodoSocialApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        setupAppConfig()
        setupTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TodoSocialApplication)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(mainFeatureModule)
        }
    }

    private fun setupAppConfig() {
        val appConfig: AppConfiguration = get()
        appConfig.apply {
            isDebug = BuildConfig.DEBUG
            baseApiUrl = BuildConfig.PREFIX
        }
    }

    private fun setupTimber() {
        val appConfig: AppConfiguration = get()
        if (appConfig.isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}