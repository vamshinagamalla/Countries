package com.walmart.countries.repo

import com.walmart.countries.data.Country

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
interface CountriesRepo {

    suspend fun retrieveCountries(): List<Country>
}