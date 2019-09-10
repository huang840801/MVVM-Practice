package com.guanhong.mvvmpractice.callback

import android.content.Context
import android.util.Log
import androidx.paging.PagedList
import com.guanhong.mvvmpractice.api.AllPlayerApi
import com.guanhong.mvvmpractice.database.DataItemDbHelper
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import com.guanhong.mvvmpractice.response.player.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PagingBoundaryCallback(private val context: Context) :
    PagedList.BoundaryCallback<DataItem>() {

    private var page = 1

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://free-nba.p.rapidapi.com/")
        .build()

    private val allPlayerData = retrofit.create(AllPlayerApi::class.java)
    private val call = allPlayerData.getAllPlayer(page)
    private val dao = DataItemDbHelper(context).getRoomDataItemDao()


    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                response.body()!!.data!!.forEach {
                    it.imageUrl =
                        "https://pdc.princeton.edu/sites/pdc/files/events/new-nba-logo-1.png"
                }

                response.body()!!.data!!.forEach {

                    dao.insert(it)
                }
                page ++
            }
        })
    }

    override fun onItemAtEndLoaded(itemAtEnd: DataItem) {
        super.onItemAtEndLoaded(itemAtEnd)

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                response.body()!!.data!!.forEach {
                    it.imageUrl =
                        "https://pdc.princeton.edu/sites/pdc/files/events/new-nba-logo-1.png"
                }

                response.body()!!.data!!.forEach {

                    dao.insert(it)
                }
                page ++
            }
        })
    }

    override fun onItemAtFrontLoaded(itemAtFront: DataItem) {
        super.onItemAtFrontLoaded(itemAtFront)
    }
}