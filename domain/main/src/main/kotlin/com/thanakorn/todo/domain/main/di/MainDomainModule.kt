package com.thanakorn.todo.domain.main.di

import com.thanakorn.todo.data.main.di.mainDataModule
import com.thanakorn.todo.domain.main.usecase.GetTodoListUseCase
import org.koin.dsl.module

val mainDomainModule = module {
    includes(mainDataModule)
    single { GetTodoListUseCase(get()) }
}