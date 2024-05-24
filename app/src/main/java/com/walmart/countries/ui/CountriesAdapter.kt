package com.walmart.countries.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countries.data.Country
import com.walmart.countries.databinding.ListItemCountryBinding

/**
 * Created by Vamshi Nagamalla on 5/23/24.
 * Copyright © Vamshi Nagamalla. All rights reserved.
 * */
class CountriesAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ListItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val country = countries[position]
        when (holder) {
            is CountryViewHolder -> holder.bind(country)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}