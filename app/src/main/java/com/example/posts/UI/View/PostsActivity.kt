package com.example.posts.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Model.Post
import com.example.posts.R
import com.example.posts.UI.Adapter.PostsAdapter

class PostsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        listSettings()
    }

    private fun listSettings() {
        val posts =  generateMockPosts()

        val adapter = PostsAdapter(posts)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun generateMockPosts(): List<Post> {
        val mockPosts = mutableListOf<Post>()
        for (i in 1..10) {
            mockPosts.add(Post(i+1, i,getString(R.string.title_post), getString(R.string.body_post)))
        }
        return mockPosts
    }
}