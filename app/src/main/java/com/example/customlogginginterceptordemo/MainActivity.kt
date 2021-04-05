package com.example.customlogginginterceptordemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var rv: RecyclerView? = null
    var rvAdapter: PostsRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.posts_rv)
        rv?.layoutManager = LinearLayoutManager(this)
        rvAdapter = PostsRVAdapter()
        rv?.adapter = rvAdapter
    }

    fun onClickGetAllPosts(v: View) {
        ApiUtils.getAllPosts(rvAdapter)
    }

    override fun onStart() {
        super.onStart()
    }
}