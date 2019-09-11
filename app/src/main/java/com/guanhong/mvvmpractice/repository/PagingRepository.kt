package com.guanhong.mvvmpractice.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.guanhong.mvvmpractice.callback.PagingBoundaryCallback
import com.guanhong.mvvmpractice.database.DataItemDbHelper
import com.guanhong.mvvmpractice.datasource.DataSourceFactory
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingRepository : PagingRepositoryCallback {

    private lateinit var remoteDataSource: DataSourceFactory
    private lateinit var localDataSource: DataSource.Factory<Int, DataItem>

    override fun getDataItem(application: Application): LiveData<PagedList<DataItem>> {

        val pagedListLiveData: LiveData<PagedList<DataItem>> by lazy {

            localDataSource = DataItemDbHelper(application).getRoomDataItemDao().getAllDataItem()
            remoteDataSource = DataSourceFactory()

            val config = PagedList.Config.Builder()
                .setPageSize(25)
                .setEnablePlaceholders(false)
//                .setInitialLoadSizeHint(5)
                .build()

            LivePagedListBuilder(localDataSource, config)
                .setBoundaryCallback(PagingBoundaryCallback(application))
                .build()
        }

        return pagedListLiveData
    }
}

interface PagingRepositoryCallback {
    fun getDataItem(application: Application): LiveData<PagedList<DataItem>>
}