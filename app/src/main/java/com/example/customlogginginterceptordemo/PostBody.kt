package com.example.customlogginginterceptordemo

import com.google.gson.annotations.SerializedName

data class PostBody(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)