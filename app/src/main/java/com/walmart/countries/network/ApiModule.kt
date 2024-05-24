package com.walmart.countries.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.walmart.countries.repo.CountriesApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(
                KotlinJsonAdapterFactory()
            ).build()))
            .build()
    }

    val api: CountriesApi by lazy {
        retrofit.create(CountriesApi::class.java)
    }
}