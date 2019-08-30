package com.guanhong.mvvmpractice.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guanhong.mvvmpractice.callback.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    var dataItem = MutableLiveData<DataItem>()
    val isLoading = ObservableBoolean()
    var color = "#FF5722"

    private var playerNo = 0

//    private val repository = MainRepository()

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

                dataItem.value = (dataItemList[playerNo++])
//                dataItem.postValue (dataItemList[playerNo])

                isLoading.set(false)
            }
        })
    }
}