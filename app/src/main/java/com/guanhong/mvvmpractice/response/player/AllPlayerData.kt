package com.guanhong.mvvmpractice.response.player

import com.google.gson.annotations.SerializedName

data class AllPlayerData(
    @SerializedName("data")
    val data: List<DataItem>?,
    @SerializedName("meta")
    val meta: Meta
)