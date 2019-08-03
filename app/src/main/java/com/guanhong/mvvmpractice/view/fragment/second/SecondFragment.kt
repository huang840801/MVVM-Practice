package com.guanhong.mvvmpractice.view.fragment.second

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.api.TupianApi
import com.guanhong.mvvmpractice.interface1.GetAllPlayerCallback
import com.guanhong.mvvmpractice.interface1.GetTupianCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.funny.Tupian
import com.guanhong.mvvmpractice.response.player.AllPlayerData
import com.guanhong.mvvmpractice.response.player.DataItem
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondFragment : Fragment() {

    lateinit var adapter: SecondAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SecondAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        getAllPlayer()
//        getTupian()
    }

    fun newInstance(): SecondFragment {
        return SecondFragment()
    }

    private fun getAllPlayer() {

        val repository = MainRepository()
        repository.getAllPlayer(object : GetAllPlayerCallback {
            override fun onSuccess(dataItemList: List<DataItem>) {
                adapter.bindAllPlayerDataList(dataItemList)
            }
        })
    }

    private fun getTupian() {

        val repository = MainRepository()
        repository.getTupian(object : GetTupianCallback {
            override fun onSuccess(tupianList: List<Tupian>) {
                adapter.bindTupainList(tupianList)
            }
        })
    }
}