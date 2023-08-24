package com.example.posts.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Data.Model.Comment
import com.example.posts.R
import com.example.posts.UI.ViewHolders.CommentsViewHolder

class CommentsAdapter (private  var comments: List<Comment>): RecyclerView.Adapter<CommentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = comments[position];
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    fun updateCommentsList(updatedPostsList: List<Comment>) {
        comments = updatedPostsList
        notifyDataSetChanged()
    }
}