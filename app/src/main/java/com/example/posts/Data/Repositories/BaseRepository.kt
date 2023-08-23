package com.example.posts.Data.Repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRepository(baseUrl: String) {
    protected val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
