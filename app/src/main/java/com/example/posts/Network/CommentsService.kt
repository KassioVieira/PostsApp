package com.example.posts.Network

import com.example.posts.Data.Model.Comment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentsService {
    @GET("/comments")
    suspend fun getCommentsbyPost(@Query("postId") postId: Int): Response<List<Comment>>
}