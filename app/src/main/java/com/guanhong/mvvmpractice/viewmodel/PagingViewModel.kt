package com.guanhong.mvvmpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.guanhong.mvvmpractice.datasource.DataSourceFactory
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingViewModel(private val repository: MainRepository) : ViewModel() {

    private val sourceFactory by lazy {
        DataSourceFactory()
    }

    val pagingDataItems: LiveData<PagedList<DataItem>> by lazy {
        sourceFactory.toLiveData(6, null)
    }
}

