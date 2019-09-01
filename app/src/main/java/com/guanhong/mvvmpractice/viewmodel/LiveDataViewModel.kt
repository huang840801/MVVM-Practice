package com.guanhong.mvvmpractice.viewmodel

import android.util.Log
import androidx.lifecycle.*

class LiveDataViewModel : ViewModel() {

    val user = MutableLiveData<User>()

    val name = MutableLiveData<String>()
    val num = MutableLiveData<Int>()

    val mediatorLiveData = MediatorLiveData<String>()

    fun addSource() {

        mediatorLiveData.addSource(name) {

            //do something when data changed
        }
        mediatorLiveData.addSource(num) {

            //do something when data changed
        }
    }

    val userFullname = Transformations.map(user) { user ->
        user.firstName + user.lastName
    }

    fun init() {

        name.value = "Wade"
    }

    fun upDateNum(num: Int) {

        this.num.postValue(num)
    }

    override fun onCleared() {

        Log.d("Huang", " onCleared")
        super.onCleared()
    }
}

data class User(
    val firstName: String,
    val lastName: String
)