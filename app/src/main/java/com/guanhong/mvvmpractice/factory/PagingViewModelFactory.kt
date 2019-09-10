package com.guanhong.mvvmpractice.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guanhong.mvvmpractice.repository.PagingRepository
import com.guanhong.mvvmpractice.viewmodel.PagingViewModel

@Suppress("UNCHECKED_CAST")
class PagingViewModelFactory(
    private val repository: PagingRepository,
    private val application: Application
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {

            when {
                isAssignableFrom(PagingViewModel::class.java) -> PagingViewModel(
                    repository,
                    application
                )

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}