package com.example.posts.Network

import com.example.posts.Data.Model.Post
import retrofit2.Response
import retrofit2.http.GET
interface PostsService {
    @GET("/posts")
    suspend fun getAllPost(): Response<List<Post>>
}