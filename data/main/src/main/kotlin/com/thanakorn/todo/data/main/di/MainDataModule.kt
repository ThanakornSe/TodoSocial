package com.thanakorn.todo.data.main.di

import android.content.Context
import androidx.room.Room
import com.thanakorn.todo.common.Constants.DB_NAME
import com.thanakorn.todo.common.di.coreCommonModule
import com.thanakorn.todo.data.main.local.dao.TodoListDao
import com.thanakorn.todo.data.main.local.database.AppDatabase
import com.thanakorn.todo.data.main.repository.TodoDataRepository
import com.thanakorn.todo.data.main.repository.TodoDataRepositoryImpl
import com.thanakorn.todo.data.main.service.TodoListService
import com.thanakorn.todo.network.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val mainDataModule = module {
    includes(retrofitModule, coreCommonModule)
    factory { provideTodoListService(get()) }
    single<TodoDataRepository> { TodoDataRepositoryImpl(get(),get(), get()) }

    single { createDb(androidContext()) }
    single { getTodoListDao(get()) }
}

private fun provideTodoListService(retrofit: Retrofit): TodoListService = retrofit.create(
    TodoListService::class.java
)

private fun createDb(context: Context): AppDatabase {
    val dbName = DB_NAME

    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        dbName
    ).build()
}

private fun getTodoListDao(appDatabase: AppDatabase): TodoListDao =
    appDatabase.todoListDao()