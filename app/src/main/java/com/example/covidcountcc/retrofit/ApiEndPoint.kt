package com.example.covidcountcc.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("indonesia")
    fun getdata(): Call<List<MainModel>>
}