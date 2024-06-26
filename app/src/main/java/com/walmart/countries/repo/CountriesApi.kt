package com.walmart.countries.repo

import com.walmart.countries.data.Country
import retrofit2.http.GET

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
interface CountriesApi {

    @GET("/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json ")
    suspend fun retrieveCountries(): List<Country>
}