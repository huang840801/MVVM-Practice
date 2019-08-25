package com.guanhong.mvvmpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestFragmentViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var id = MutableLiveData<Int>()
}