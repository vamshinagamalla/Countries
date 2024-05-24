package com.walmart.countries.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walmart.countries.data.Country
import com.walmart.countries.repo.CountriesRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
class MainViewModel: ViewModel() {

    lateinit var repo: CountriesRepo
    lateinit var ioDispatcher: CoroutineDispatcher

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> get() = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val countriesList = repo.retrieveCountries()
                _countries.postValue(countriesList)
            } catch (e: Exception) {
                Log.e(MainViewModel::class.simpleName, "failed to fetch countries", e)
            }
        }
    }
}