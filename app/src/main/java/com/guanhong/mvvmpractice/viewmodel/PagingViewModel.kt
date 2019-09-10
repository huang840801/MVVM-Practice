package com.guanhong.mvvmpractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.guanhong.mvvmpractice.database.DataItemDbHelper
import com.guanhong.mvvmpractice.datasource.DataSourceFactory
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.repository.PagingRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingViewModel(
    private val repository: PagingRepository,
    application: Application
) : AndroidViewModel(application) {

    private val sourceFactory by lazy {
        DataSourceFactory()
    }

    val pagingDataItems: LiveData<PagedList<DataItem>> by lazy {

        sourceFactory.toLiveData(6, null)
    }

    private val dao = DataItemDbHelper(application).getRoomDataItemDao()

    //    val aa = LiveData<PagedList<DataItem>>
//    val localDataItem = LivePagedListBuilder(
//        dao.getAllDataItem(),
//        PagedList.Config.Builder()
//            .setEnablePlaceholders(true)
//            .setPageSize(15)
//            .setInitialLoadSizeHint(5)
//            .build()
//    ).build()

    fun aa(){


        repository.getDataItem()
    }

    val pagedListLiveData: LiveData<PagedList<DataItem>> by lazy {

        val dataSourceFactory = dao.getAllDataItem()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(15)
            .setInitialLoadSizeHint(5)
            .build()

        LivePagedListBuilder(dataSourceFactory, config).build()

    }
}

