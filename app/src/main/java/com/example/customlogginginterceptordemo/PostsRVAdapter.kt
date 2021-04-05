package com.example.customlogginginterceptordemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsRVAdapter : RecyclerView.Adapter<PostsRVAdapter.PostsRVViewHolder>() {

    var postsData: List<PostBody>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsRVViewHolder {
        return PostsRVViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_posts_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostsRVViewHolder, position: Int) {
        postsData?.get(position)?.let {
            holder.title.text = it.title
            holder.body.text = it.body
        }
    }

    override fun getItemCount(): Int {
        return postsData?.size ?: 0
    }

    class PostsRVViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.posts_rv_title_text_view)
        val body: TextView = view.findViewById(R.id.posts_rv_body_text_view)
    }

}