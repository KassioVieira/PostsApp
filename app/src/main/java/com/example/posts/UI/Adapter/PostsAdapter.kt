package com.example.posts.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.Data.Model.Post
import com.example.posts.R
import com.example.posts.UI.ViewHolders.PostsViewHolder

class PostsAdapter(private  var posts: List<Post>, private val clickListener: OnPostItemClickListener): RecyclerView.Adapter<PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position];
        holder.bind(post)

        holder.itemView.setOnClickListener {
            clickListener.onPostItemClick(post)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun updatePostList(updatedPostsList: List<Post>) {
        posts = updatedPostsList
        notifyDataSetChanged()
    }
}

interface OnPostItemClickListener {
    fun onPostItemClick(post: Post)
}