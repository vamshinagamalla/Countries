package com.walmart.countries.ui

import androidx.recyclerview.widget.RecyclerView
import com.walmart.countries.data.Country
import com.walmart.countries.databinding.ListItemCountryBinding

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
class CountryViewHolder(private val binding: ListItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country) {
        binding.country = country
    }
}