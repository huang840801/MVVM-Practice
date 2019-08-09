package com.guanhong.mvvmpractice.view.fragment.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.callback.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem
import kotlinx.android.synthetic.main.fragment_second.*

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
}