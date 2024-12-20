package com.thanakorn.todo.network.di

import com.thanakorn.todo.common.base.AppConfiguration
import com.thanakorn.todo.common.di.coreCommonModule
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule =
    module {
        includes(networkModule, coreCommonModule)
        single { createRetrofit(get(), get()) }
    }

private fun createRetrofit(
    appConfiguration: AppConfiguration,
    okHttpClient: OkHttpClient,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(appConfiguration.baseApiUrl ?: "")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
