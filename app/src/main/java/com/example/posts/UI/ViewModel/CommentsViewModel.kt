package com.example.posts.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.posts.Data.Model.Comment
import com.example.posts.Data.Repositories.CommentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CommentsViewModel: ViewModel() {
    private val commentsRepository = CommentsRepository()

    val commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()

    fun getAllCommentsByPost(postId: Int) {
        GlobalScope.launch(Dispatchers.Main){
            val comments = commentsRepository.getCommentsByPost(postId);
            comments?.let {
               commentsLiveData.postValue(it)
            }
        }
    }
}