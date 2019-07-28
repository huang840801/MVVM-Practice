package com.guanhong.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.api.AllPlayerApi
import com.guanhong.mvvmpractice.databinding.ActivityMainBinding
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getAllPlayer()
    }

    fun onViewClick(view: View) {

        when (view) {
            is TextView -> {
                showToast(view.text.toString())
            }
        }
    }

    private fun getAllPlayer() {

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

                binding!!.dataItem = response.body().data!![0]
            }
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
