package com.guanhong.mvvmpractice.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.guanhong.mvvmpractice.api.AllPlayerApi
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import com.guanhong.mvvmpractice.response.player.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PagingDataSource : PageKeyedDataSource<String, DataItem>() {

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://free-nba.p.rapidapi.com/")
        .build()

    private val allPlayerData = retrofit.create(AllPlayerApi::class.java)

    private var page = 1

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, DataItem>
    ) {

        Log.d("Huang", " loadInitial ")

        val call = allPlayerData.getAllPlayer(page)

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                response.body()!!.data!!.forEach {
                    it.imageUrl =
                        "https://pdc.princeton.edu/sites/pdc/files/events/new-nba-logo-1.png"
                }

                callback.onResult(response.body()!!.data!!, null, page.toString())
            }
        })
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, DataItem>) {

        Log.d("Huang", " params key " + params.key)
        Log.d("Huang", " requestedLoadSize " + params.requestedLoadSize)

        val call = allPlayerData.getAllPlayer(page)

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                response.body()!!.data!!.forEach {
                    it.imageUrl =
                        "https://pdc.princeton.edu/sites/pdc/files/events/new-nba-logo-1.png"
                }

                callback.onResult(response.body()!!.data!!, page.toString())

                page += 1

            }
        })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, DataItem>) {
    }
}