package com.guanhong.mvvmpractice.viewmodel

import androidx.databinding.ObservableField
import com.guanhong.mvvmpractice.interface1.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class MainViewModel {

    private val repository = MainRepository()

    val data = ObservableField<List<DataItem>>()
    val dataItem = ObservableField<DataItem>()

    private var playerNo = 0

    fun refresh(){

        repository.getAllPlayer(object :GetAllPlayerCallback{
            override fun onSuccess(dataItemList: List<DataItem>) {
                data.set(dataItemList)
                dataItem.set(dataItemList[playerNo])

                playerNo ++
            }
        })
    }
}