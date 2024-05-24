package com.walmart.countries.repo

import com.walmart.countries.data.Country

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
class CountriesRepoImpl(private val api: CountriesApi): CountriesRepo {

    override fun retrieveCountries(): List<Country> = api.retrieveCountries()
}