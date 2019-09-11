package com.guanhong.mvvmpractice.api

import com.guanhong.mvvmpractice.response.player.AllPlayerData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AllPlayerApi {

    companion object {

        private val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://free-nba.p.rapidapi.com/")
            .build()

        val api = retrofit.create(AllPlayerApi::class.java)
    }

    @Headers(
        "Content-Type:application/json",
        "X-RapidAPI-Host:free-nba.p.rapidapi.com",
        "X-RapidAPI-Key:209adafb56mshf0c72255364e1c0p1d5ee5jsn0951b1fbba9d"
    )
    @GET("players")
    fun getAllPlayer(@Query("page") page: Int): Call<AllPlayerData>

    @Headers(
        "Content-Type:application/json",
        "X-RapidAPI-Host:free-nba.p.rapidapi.com",
        "X-RapidAPI-Key:209adafb56mshf0c72255364e1c0p1d5ee5jsn0951b1fbba9d"
    )
    @GET("players")
    fun getAllPlayer(): Call<AllPlayerData>
}