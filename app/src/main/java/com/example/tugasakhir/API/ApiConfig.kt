package com.example.tugasakhir.API

import com.example.tugasakhir.ResponseApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiConfig {
    const val baseURL = "http://192.168.1.30/tarafi/public/api/"
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}