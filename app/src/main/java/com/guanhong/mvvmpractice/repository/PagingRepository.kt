package com.guanhong.mvvmpractice.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.guanhong.mvvmpractice.callback.PagingBoundaryCallback
import com.guanhong.mvvmpractice.database.DataItemDbHelper
import com.guanhong.mvvmpractice.datasource.DataSourceFactory
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingRepository : PagingRepositoryCallback {

    private val sourceFactory by lazy {
        DataSourceFactory()
    }

    override fun getDataItem(application: Application): LiveData<PagedList<DataItem>> {

        val dao = DataItemDbHelper(application).getRoomDataItemDao()

        val pagedListLiveData: LiveData<PagedList<DataItem>> by lazy {

            val dataSourceFactory = dao.getAllDataItem()
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(15)
                .setInitialLoadSizeHint(5)
                .build()

            LivePagedListBuilder(dataSourceFactory, config)
                .setBoundaryCallback(PagingBoundaryCallback(application))
                .build()
        }

        return pagedListLiveData
    }
}

interface PagingRepositoryCallback {
    fun getDataItem(application: Application): LiveData<PagedList<DataItem>>
}