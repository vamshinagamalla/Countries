package com.walmart.countries.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.walmart.countries.R
import com.walmart.countries.databinding.ActivityMainBinding
import com.walmart.countries.network.RetrofitInstance
import com.walmart.countries.repo.CountriesApiClient
import com.walmart.countries.repo.CountriesRepoImpl
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class]
        viewModel.ioDispatcher = Dispatchers.IO
        viewModel.repo = CountriesRepoImpl(CountriesApiClient(RetrofitInstance.api))
        viewModel.fetchCountries()
        enableEdgeToEdge()

        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.countries.observe(this) { countries ->
            val adapter = CountriesAdapter(countries)
            binding.recyclerView.adapter = adapter
        }
    }
}