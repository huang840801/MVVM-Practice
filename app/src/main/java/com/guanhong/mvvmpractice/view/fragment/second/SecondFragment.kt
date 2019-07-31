package com.guanhong.mvvmpractice.view.fragment.second

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.api.AllPlayerApi
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_second, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SecondAdapter()
        recyclerView.adapter = adapter

    }

    fun newInstance(): SecondFragment {
        return SecondFragment()
    }

    fun getAllPlayer() {

        val retrofit = Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://free-nba.p.rapidapi.com/")
                .build()

        val allPlayerData = retrofit.create(AllPlayerApi::class.java)

        val call = allPlayerData.getAllPlayer(3)

        call.enqueue(object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")

            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

//                binding.dataItem = response.body().data!![0]
            }
        })
    }
}