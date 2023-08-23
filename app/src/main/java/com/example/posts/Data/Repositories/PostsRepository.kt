package com.example.posts.Data.Repositories

import com.example.posts.Data.Model.Post
import com.example.posts.Network.PostsService
import com.example.posts.Utils.Constants

class PostsRepository: BaseRepository(Constants.BASE_URL) {
    private val postsService: PostsService = retrofit.create(PostsService::class.java)
    suspend fun getAllPosts(): List<Post>? {
        val response = postsService.getAllPost()
        if(response.isSuccessful) {
            return response.body()
        }
        return null;
    }
}