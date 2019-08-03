package com.guanhong.mvvmpractice.response.funny

import com.google.gson.annotations.SerializedName

data class Tupian(
    @SerializedName("sourceurl")
    val sourceurl: String = "",
    @SerializedName("width")
    val width: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("thumburl")
    val thumburl: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("height")
    val height: String = ""
)