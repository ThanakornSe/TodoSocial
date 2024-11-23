package com.thanakorn.todo.common.di

import com.thanakorn.todo.common.AppConfig
import com.thanakorn.todo.common.base.AppConfiguration
import com.thanakorn.todo.common.util.DefaultDispatchers
import com.thanakorn.todo.common.util.DispatcherProvider
import org.koin.dsl.module

val coreCommonModule = module {
    single<AppConfiguration> { AppConfig }
    single<DispatcherProvider> { DefaultDispatchers() }
}