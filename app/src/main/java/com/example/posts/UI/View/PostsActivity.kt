package com.example.posts.UI.View

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Extensions.obtainPostsViewModel
import com.example.posts.R
import com.example.posts.UI.Adapter.PostsAdapter
import com.example.posts.UI.ViewModel.PostsViewModel
import com.facebook.shimmer.ShimmerFrameLayout

class PostsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postsViewModel: PostsViewModel
    private lateinit var adapter: PostsAdapter
    private lateinit var shimmerLayout: ShimmerFrameLayout
    private lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewReferences()
        setupRecyclerView()
        listenPostsChanges()

        postsViewModel.fetchAllPosts()
    }

    private fun setupViewReferences() {
        postsViewModel = obtainPostsViewModel()
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setupRecyclerView() {

        scrollView = findViewById(R.id.scrollView)
        shimmerLayout = findViewById(R.id.skeleton)
        shimmerLayout.startShimmer()

        adapter = PostsAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun listenPostsChanges() {
        postsViewModel.postLiveData.observe(this, Observer { posts ->
            adapter.updatePostList(posts)
            Handler().postDelayed({
                shimmerLayout.stopShimmer()
                scrollView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }, 1000)
        })
    }
}
