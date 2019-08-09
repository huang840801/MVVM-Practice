package com.guanhong.mvvmpractice.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.guanhong.mvvmpractice.callback.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem
import com.guanhong.mvvmpractice.response.player.Team

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

//    val data = ObservableField<List<DataItem>>()
//    val dataItem = ObservableField<DataItem>()

    //    val data = MutableLiveData<List<DataItem>>()
    var dataItem = MutableLiveData<DataItem>()

    val isLoading = ObservableBoolean()

    var test = MutableLiveData<String>()
    var num = 0

    private var playerNo = 0

    fun refresh() {

        Log.d("Huang", " MainViewModel refresh")

        setTestValue()
//        getAllPlayer()
    }

    fun init() {
        getAllPlayer()
    }

    fun getDataItem(): LiveData<DataItem> {

        return dataItem
    }

    private fun getAllPlayer() {

        Log.d("Huang", " MainViewModel getAllPlayer")

        isLoading.set(true)
        val team = Team()

//        val test = DataItem(0, 0, 0, "aaa", 0, "", team, " sss", "")

//        dataItem.postValue(test)

        repository.getAllPlayer(object : GetAllPlayerCallback {
            override fun onSuccess(dataItemList: List<DataItem>) {

                Log.d("Huang", " onSuccess " + dataItemList[0].firstName)
                Log.d("Huang", " onSuccess " + dataItemList[0].lastName)
                Log.d("Huang", " onSuccess " + dataItemList.count())

//                data.postValue(dataItemList)
                dataItem.value = (dataItemList[playerNo])

//                data.value = dataItemList
//                dataItem.value = dataItemList[playerNo]
//                data.set(dataItemList)
//                dataItem.set(dataItemList[playerNo])

                isLoading.set(false)
                playerNo++
            }
        })
    }

    fun Test() {
        setTestValue()
    }

    fun setTestValue() {
        test.value = "Test" + num

        num++
    }
}