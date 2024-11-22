package com.thanakorn.todo.di

import com.thanakorn.todo.common.di.coreCommonModule
import com.thanakorn.todo.feature.main.di.mainFeatureModule
import org.koin.dsl.module

val appModule = module {
    includes(
        mainFeatureModule,
        coreCommonModule
    )
}