package com.guanhong.mvvmpractice.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guanhong.mvvmpractice.callback.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.PlayerRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class PlayerFragmentViewModel : ViewModel() {

    lateinit var repository: PlayerRepository

    lateinit var isLoading: MutableLiveData<Boolean>
    lateinit var observablePage: ObservableInt
    lateinit var dataItemList: MutableLiveData<List<DataItem>>

    var page = 1

    fun refresh() {

        getAllPlayer(page)
    }

    fun init() {

        repository = PlayerRepository()
        dataItemList = MutableLiveData()
        isLoading = MutableLiveData()
        observablePage = ObservableInt()

        getAllPlayer(page)
    }

    private fun getAllPlayer(page: Int) {

        Log.d("Huang", " page1 = $page")

        isLoading.value = true

        repository.getAllPlayer(page, object : GetAllPlayerCallback {
            override fun onSuccess(dataItemList: List<DataItem>) {

                this@PlayerFragmentViewModel.dataItemList.value = dataItemList
                this@PlayerFragmentViewModel.page++

                observablePage.set(page)
                isLoading.value = false
            }
        })
    }
}