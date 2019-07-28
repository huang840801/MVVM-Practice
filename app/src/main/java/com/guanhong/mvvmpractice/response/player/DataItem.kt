package com.guanhong.mvvmpractice.response.player

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("weight_pounds")
    val weightPounds: Int? = 0,
    @SerializedName("height_feet")
    val heightFeet: Int? = 0,
    @SerializedName("height_inches")
    val heightInches: Int? = 0,
    @SerializedName("last_name")
    var lastName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("position")
    val position: String = "",
    @SerializedName("team")
    val team: Team?,
    @SerializedName("first_name")
    var firstName: String = ""
)