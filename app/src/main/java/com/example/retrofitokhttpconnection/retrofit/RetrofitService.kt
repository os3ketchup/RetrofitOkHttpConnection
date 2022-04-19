package com.example.retrofitokhttpconnection.retrofit

import com.example.retrofitokhttpconnection.models.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMarvel(): Single<List<Movie>>
}