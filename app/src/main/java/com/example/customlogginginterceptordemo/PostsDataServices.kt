package com.example.customlogginginterceptordemo

import retrofit2.Call
import retrofit2.http.GET

interface PostsDataServices {

    @GET("/posts")
    fun getAllPosts(): Call<List<PostBody>>
}