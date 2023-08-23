package com.example.posts.UI.ViewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Data.Model.Post
import com.example.posts.R

class PostsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val bodyTextView = itemView.findViewById<TextView>(R.id.body)

    fun bind(post: Post) {
        bodyTextView.text = post.body
    }

}