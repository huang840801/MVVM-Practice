package com.guanhong.mvvmpractice.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.viewmodel.MainViewModel
import com.guanhong.mvvmpractice.viewmodel.SpinnerViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val repository: MainRepository) :
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