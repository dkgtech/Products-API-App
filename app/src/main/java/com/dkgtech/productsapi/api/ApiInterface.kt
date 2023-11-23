package com.dkgtech.productsapi.api

import com.dkgtech.productsapi.model.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProducts(): Call<DataModel>

}