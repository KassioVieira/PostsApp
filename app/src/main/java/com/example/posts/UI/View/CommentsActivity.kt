package com.example.posts.UI.View

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Data.Model.Post
import com.example.posts.Extensions.obtainCommentsViewModel
import com.example.posts.R
import com.example.posts.UI.Adapter.CommentsAdapter
import com.example.posts.UI.ViewModel.CommentsViewModel
import com.facebook.shimmer.ShimmerFrameLayout

class CommentsActivity : AppCompatActivity() {

    private lateinit var recyclerViewComments: RecyclerView
    private lateinit var bodyPost: TextView
    private lateinit var commentsViewModel: CommentsViewModel
    private lateinit var adapter: CommentsAdapter
    private lateinit var shimmerLayout: ShimmerFrameLayout
    private lateinit var scrollView: ScrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        setupReferences()
        setupRecyclerView()

        val post = intent.getSerializableExtra("post") as? Post
        if (post != null) {
            bodyPost.text = post.body
            commentsViewModel.getAllCommentsByPost(post.id)
        }

        listenCommentsChanges()

    }

    private fun setupRecyclerView() {

        scrollView = findViewById(R.id.scrollView)
        shimmerLayout = findViewById(R.id.skeleton_comments)
        shimmerLayout.startShimmer()

        adapter = CommentsAdapter(emptyList())
        recyclerViewComments.adapter = adapter
        recyclerViewComments.layoutManager = LinearLayoutManager(this)
    }

    private fun setupReferences() {
        commentsViewModel = obtainCommentsViewModel()
        bodyPost = findViewById(R.id.body_post)
        recyclerViewComments = findViewById(R.id.recyclerViewComments)
    }

    private fun listenCommentsChanges() {
        commentsViewModel.commentsLiveData.observe(this) { comments ->
            adapter.updateCommentsList(comments)
            Handler().postDelayed({
                shimmerLayout.stopShimmer()
                scrollView.visibility = View.GONE
                recyclerViewComments.visibility = View.VISIBLE
            }, 1000)
        }
    }
}