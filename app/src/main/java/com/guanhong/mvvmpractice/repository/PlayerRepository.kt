package com.guanhong.mvvmpractice.repository

import android.util.Log
import com.guanhong.mvvmpractice.api.AllPlayerApi
import com.guanhong.mvvmpractice.callback.GetAllPlayerCallback
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlayerRepository {

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://free-nba.p.rapidapi.com/")
        .build()

    private val allPlayerData = retrofit.create(AllPlayerApi::class.java)

    fun getAllPlayer(page: Int, callback: GetAllPlayerCallback) {


        val call = allPlayerData.getAllPlayer(page)

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                response.body()!!.data!!.forEach {
                    it.imageUrl = "https://pdc.princeton.edu/sites/pdc/files/events/new-nba-logo-1.png"
                }

                callback.onSuccess(response.body()!!.data!!)
            }
        })
    }
}