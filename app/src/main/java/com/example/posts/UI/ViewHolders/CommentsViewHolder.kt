package com.example.posts.UI.ViewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Data.Model.Comment
import com.example.posts.R

class CommentsViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    private val titleComment = itemView.findViewById<TextView>(R.id.comment_title)
    private val bodyComment = itemView.findViewById<TextView>(R.id.comment_body)

    fun bind(comment: Comment) {
        titleComment.text = comment.name
        bodyComment.text = comment.body
    }

}