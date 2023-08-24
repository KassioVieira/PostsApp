package com.example.posts.Extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.posts.UI.ViewModel.CommentsViewModel
import com.example.posts.UI.ViewModel.PostsViewModel
fun AppCompatActivity.obtainPostsViewModel(): PostsViewModel {
    return ViewModelProvider(this).get(PostsViewModel::class.java)
}

fun AppCompatActivity.obtainCommentsViewModel(): CommentsViewModel {
    return ViewModelProvider(this).get(CommentsViewModel::class.java)
}