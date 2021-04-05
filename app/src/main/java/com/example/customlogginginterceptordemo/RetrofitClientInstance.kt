package com.example.customlogginginterceptordemo

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val interceptor = HttpLoggingInterceptor()

    private var client: OkHttpClient? = null

    init {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}