package com.daerawind.nextdoor.di

import com.daerawind.nextdoor.data.api.ApiService
import com.daerawind.nextdoor.data.api.story.StoryRemoteData
import com.daerawind.nextdoor.data.api.story.StoryRepository
import com.daerawind.nextdoor.view.StoryViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

var myModules = module {
    // network modules
    single { buildRetrofit() }
    single { createApiService(get()) }

    // singletons
    single { StoryRemoteData(get()) }
    single { StoryRepository(get()) }

    // view models
    viewModel { StoryViewModel(get()) }
}

fun buildRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(ApiService.baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(buildOkHttpClient())
        .build()
}

fun buildOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun createApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}