package com.guanhong.mvvmpractice.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val num = MutableLiveData<Int>()

    fun init() {

        name.value = "Wade"
    }

    fun upDateNum(num: Int) {

        this.num.postValue(num)

    }
}