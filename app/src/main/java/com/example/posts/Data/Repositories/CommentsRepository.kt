package com.example.posts.Data.Repositories

import com.example.posts.Data.Model.Comment
import com.example.posts.Network.CommentsService
import com.example.posts.Utils.Constants

class CommentsRepository: BaseRepository(Constants.BASE_URL) {
    private val commentsService: CommentsService = retrofit.create(CommentsService::class.java)
    suspend fun getCommentsByPost(postId: Int): List<Comment>? {
        val response = commentsService.getCommentsbyPost(postId)
        if(response.isSuccessful) {
            return response.body()
        }
        return null;
    }
}