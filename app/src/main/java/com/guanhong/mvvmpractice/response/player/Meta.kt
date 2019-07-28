package com.guanhong.mvvmpractice.response.player

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("next_page")
    val nextPage: Int = 0,
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("total_count")
    val totalCount: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("current_page")
    val currentPage: Int = 0
)