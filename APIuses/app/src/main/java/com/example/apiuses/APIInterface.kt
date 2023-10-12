package com.example.apiuses

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("products")
    fun getProductData() : Call<MyData>

}