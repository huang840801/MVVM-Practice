package com.guanhong.mvvmpractice.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {
    var name = MediatorLiveData<String>()

    fun init() {

        name.value = "Wade"
    }
}