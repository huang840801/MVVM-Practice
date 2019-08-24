package com.guanhong.mvvmpractice.viewmodel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class TestViewModel {

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
