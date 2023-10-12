package com.example.music_application

import android.os.Parcel
import android.os.Parcelable
import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface{

    @Headers("X-RapidAPI-Key:b83a031982mshfb8ac07bc6a52e9p18f895jsn12de6b8de20e",
        "X-RapidAPI-Host :deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q")query : String) : Call<MyData>

}