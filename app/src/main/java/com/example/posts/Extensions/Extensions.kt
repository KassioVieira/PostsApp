package com.example.posts.Extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.posts.UI.ViewModel.PostsViewModel
fun AppCompatActivity.obtainPostsViewModel(): PostsViewModel {
    return ViewModelProvider(this).get(PostsViewModel::class.java)
}