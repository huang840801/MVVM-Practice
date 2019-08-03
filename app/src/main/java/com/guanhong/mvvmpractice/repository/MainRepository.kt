package com.guanhong.mvvmpractice.repository

import android.util.Log
import com.guanhong.mvvmpractice.api.AllPlayerApi
import com.guanhong.mvvmpractice.api.TupianApi
import com.guanhong.mvvmpractice.interface1.GetAllPlayerCallback
import com.guanhong.mvvmpractice.interface1.GetTupianCallback
import com.guanhong.mvvmpractice.response.funny.Tupian
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {

    fun getAllPlayer(callback: GetAllPlayerCallback) {

        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://free-nba.p.rapidapi.com/")
            .build()

        val allPlayerData = retrofit.create(AllPlayerApi::class.java)

        val call = allPlayerData.getAllPlayer(2)

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                response.body().imageUrl = "https://pdc.princeton.edu/sites/pdc/files/events/new-nba-logo-1.png"
                callback.onSuccess(response.body().data!!)
            }
        })
    }

    fun getTupian(callback: GetTupianCallback) {

        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.laifudao.com/open/")
            .build()

        val tupian = retrofit.create(TupianApi::class.java)

        val call = tupian.getTupian()

        call.enqueue(object : Callback<List<Tupian>> {
            override fun onFailure(call: Call<List<Tupian>>?, t: Throwable?) {
                Log.d("Huang", " get tupian fail ")
            }

            override fun onResponse(call: Call<List<Tupian>>?, response: Response<List<Tupian>>?) {
                Log.d("Huang", " get tupian success ")
                callback.onSuccess(response!!.body())
            }
        })
    }
}