package com.thanakorn.todo.data.main.di

import com.thanakorn.todo.data.main.repository.TodoDataRepository
import com.thanakorn.todo.data.main.repository.TodoDataRepositoryImpl
import com.thanakorn.todo.data.main.service.TodoListService
import com.thanakorn.todo.network.di.retrofitModule
import org.koin.dsl.module
import retrofit2.Retrofit

val mainDataModule = module {
    includes(retrofitModule)
    factory { provideTodoListService(get()) }
    single<TodoDataRepository> { TodoDataRepositoryImpl(get()) }
}

private fun provideTodoListService(retrofit: Retrofit): TodoListService = retrofit.create(
    TodoListService::class.java
)