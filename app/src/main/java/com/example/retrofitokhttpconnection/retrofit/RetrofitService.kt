package com.example.retrofitokhttpconnection.retrofit

import com.example.retrofitokhttpconnection.models.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMarvel(): Call<List<Movie>>
}