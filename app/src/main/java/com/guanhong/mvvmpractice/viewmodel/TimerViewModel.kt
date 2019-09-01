package com.guanhong.mvvmpractice.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class TimerViewModel :ViewModel(){

    var userName = ObservableInt()
    var userId: Int = 30
    var test: Boolean = false
    val cityList: MutableList<City> = mutableListOf()

     var city = ObservableField<City>()

    fun updateUserName(userName: Int) {

        this.userName.set(userName)
    }

    fun onClick(s: Boolean) {

    }

    override fun onCleared() {

        Log.d("Huang"," onCleared")
        super.onCleared()
    }
    fun updateCityList() {

        city.set(City("Tainan", 710))
        cityList.add(City("Tainan", 710))
        cityList.add(City("Taipei", 110))
    }
}

data class City(
    val city: String,
    val cityCode: Int
)
