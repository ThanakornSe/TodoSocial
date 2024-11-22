package com.thanakorn.todo.feature.main.di

import com.thanakorn.todo.domain.main.di.mainDomainModule
import com.thanakorn.todo.feature.main.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainFeatureModule = module {
    includes(mainDomainModule)
    viewModelOf(::HomeViewModel)
}