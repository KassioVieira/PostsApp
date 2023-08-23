package com.example.posts.UI.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.R
import com.example.posts.UI.Adapter.PostsAdapter
import com.example.posts.UI.ViewModel.PostsViewModel

class PostsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postsViewModel: PostsViewModel
    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewReferences()
        setupRecyclerView()
        listenPostsChanges()

        postsViewModel.fetchAllPosts()
    }

    private fun setupViewReferences() {
        postsViewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setupRecyclerView() {
        adapter = PostsAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun listenPostsChanges() {
        postsViewModel.postLiveData.observe(this, Observer { posts ->
            adapter.updatePostList(posts)
        })
    }
}
