package com.example.customlogginginterceptordemo

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiUtils {

    fun getAllPosts(rvAdapter: PostsRVAdapter?) {
        val instance =
            RetrofitClientInstance.getRetrofitInstance()?.create(PostsDataServices::class.java)
        val call: Call<List<PostBody>>? = instance?.getAllPosts()
        call?.enqueue(object : Callback<List<PostBody>> {
            override fun onFailure(call: Call<List<PostBody>>, t: Throwable) {
//                Log.v("MyApp", t.localizedMessage.orEmpty())
            }

            override fun onResponse(
                call: Call<List<PostBody>>,
                response: Response<List<PostBody>>
            ) {
//                Log.v("MyApp", response.body().toString())
                rvAdapter?.postsData = response.body()
                rvAdapter?.notifyDataSetChanged()
            }

        })
    }

}