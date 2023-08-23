package com.example.posts.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.posts.Data.Model.Post
import com.example.posts.Data.Repositories.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {
    private val postsRepository = PostsRepository()

    val postLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun fetchAllPosts() {
        GlobalScope.launch(Dispatchers.Main){
            val posts = postsRepository.getAllPosts()
            posts?.let {
                postLiveData.postValue(it)
            }
        }
    }

}