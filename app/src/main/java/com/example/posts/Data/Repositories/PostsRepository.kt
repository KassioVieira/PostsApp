package com.example.posts.Data.Repositories

import com.example.posts.Data.Model.Post
import com.example.posts.Network.PostsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsRepository {
    private val postsService: PostsService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        postsService = retrofit.create(PostsService::class.java)
    }

    suspend fun getAllPosts(): List<Post>? {
        val response = postsService.getAllPost()
        if(response.isSuccessful) {
            return response.body()
        }
        return null;
    }
}