package com.guanhong.mvvmpractice.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: MainRepository,
    private val application: Application
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {

            when {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}