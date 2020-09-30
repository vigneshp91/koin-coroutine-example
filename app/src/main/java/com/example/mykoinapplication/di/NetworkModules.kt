package com.example.mykoinapplication.di

import com.example.mykoinapplication.BuildConfig
import com.example.mykoinapplication.network.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    single { provideRetrofit(get()) }
    factory { provideApiInterface(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideLoggingInterceptor() }
}

fun provideLoggingInterceptor() :HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
    return Retrofit.Builder().baseUrl("https://reqres.in/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}


fun provideApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)
