package com.daangn.www.koinphotosample.di

import com.daangn.www.koinphotosample.BuildConfig
import com.daangn.www.koinphotosample.api.Api
import com.daangn.www.koinphotosample.photo.photoListModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule: Module = module {

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        Retrofit.Builder()
             .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl(getProperty<String>("BASE_URL"))
             .build()
             .create(Api::class.java)
    }
}

val appModules = listOf(apiModule, photoListModule)