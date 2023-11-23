package com.dkgtech.productsapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.productsapi.R
import com.dkgtech.productsapi.adapter.RecyclerProductsAdapter
import com.dkgtech.productsapi.api.ApiInterface
import com.dkgtech.productsapi.databinding.ActivityMainBinding
import com.dkgtech.productsapi.model.DataModel
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            getProducts()

        }
    }

    private fun getProducts() {
        val retrofit =
            Retrofit.Builder().baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiInterface::class.java)

        val response = retrofit.getProducts().enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.isSuccessful) {
                    response.body().let {
                        for (products in response.body()?.products!!) {
                            binding.rcViewProducts.layoutManager =
                                LinearLayoutManager(this@MainActivity)
                            binding.rcViewProducts.adapter =
                                RecyclerProductsAdapter(
                                    this@MainActivity,
                                    arrProducts = response.body()!!.products
                                )
                        }
                    }
                }
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}