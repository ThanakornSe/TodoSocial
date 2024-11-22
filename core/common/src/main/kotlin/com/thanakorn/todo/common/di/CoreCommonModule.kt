package com.thanakorn.todo.common.di

import com.thanakorn.todo.common.AppConfig
import com.thanakorn.todo.common.base.AppConfiguration
import org.koin.dsl.module

val coreCommonModule = module {
    single<AppConfiguration> { AppConfig }
}