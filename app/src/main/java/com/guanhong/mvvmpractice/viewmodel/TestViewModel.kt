package com.guanhong.mvvmpractice.viewmodel

import android.database.Observable
import android.util.Log
import androidx.databinding.ObservableField

class TestViewModel {

    var userName = ObservableField<String>()
    var userId: Int = 30
    var test: Boolean = false
    val cityList: MutableList<City> = mutableListOf()

     var city = ObservableField<City>()

    fun updateUserName(userName: String) {

        Log.d("Huang", " updateUserName "+userName)

        this.userName.set(userName)
    }

    fun onClick(s: Boolean) {

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