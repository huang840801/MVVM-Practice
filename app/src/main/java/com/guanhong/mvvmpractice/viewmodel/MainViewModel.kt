package com.guanhong.mvvmpractice.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.guanhong.mvvmpractice.callback.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class MainViewModel {

    private val repository = MainRepository()

    val data = ObservableField<List<DataItem>>()
    val dataItem = ObservableField<DataItem>()

    val isLoading = ObservableBoolean()

    private var playerNo = 0

    fun refresh() {
        getAllPlayer()
    }

    fun init() {
        getAllPlayer()
    }

    private fun getAllPlayer() {

        isLoading.set(true)

        repository.getAllPlayer(object : GetAllPlayerCallback {
            override fun onSuccess(dataItemList: List<DataItem>) {
                data.set(dataItemList)
                dataItem.set(dataItemList[playerNo])

                isLoading.set(false)
                playerNo++
            }
        })
    }
}