package com.guanhong.mvvmpractice.response.player

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("division")
    val division: String = "",
    @SerializedName("conference")
    val conference: String = "",
    @SerializedName("full_name")
    val fullName: String = "",
    @SerializedName("city")
    val city: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("abbreviation")
    val abbreviation: String = ""
)