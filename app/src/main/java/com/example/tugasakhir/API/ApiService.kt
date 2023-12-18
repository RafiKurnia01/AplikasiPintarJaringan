package com.example.tugasakhir.API

import com.example.tugasakhir.ResponseApi
import com.example.tugasakhir.ResponseApi2
import com.example.tugasakhir.ResponseApi3
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("konten/1")
    fun getApi () : Call<ResponseApi>

    @GET("konten/2")
    fun getApi2 () : Call<ResponseApi2>

    @GET("konten/3")
    fun getApi3 () : Call<ResponseApi3>
}