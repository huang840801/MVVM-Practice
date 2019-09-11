package com.guanhong.mvvmpractice.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.guanhong.mvvmpractice.callback.PagingBoundaryCallback
import com.guanhong.mvvmpractice.database.DataItemDao
import com.guanhong.mvvmpractice.database.DataItemDbHelper
import com.guanhong.mvvmpractice.datasource.DataSourceFactory
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingRepository : PagingRepositoryCallback {

    private val remoteSourceFactory by lazy {
        DataSourceFactory()
    }

    private lateinit var localSourceFactory: DataItemDao

    override fun getDataItem(application: Application): LiveData<PagedList<DataItem>> {

        val dao = DataItemDbHelper(application).getRoomDataItemDao()

        val pagedListLiveData: LiveData<PagedList<DataItem>> by lazy {

            val localDataSource = dao.getAllDataItem()
            val remoteDataSource = remoteSourceFactory

            val config = PagedList.Config.Builder()
                .setPageSize(25)
                .setEnablePlaceholders(false)
//                .setInitialLoadSizeHint(5)
                .build()

            LivePagedListBuilder(remoteDataSource, config)
                .setBoundaryCallback(PagingBoundaryCallback(application))
                .build()
        }

        return pagedListLiveData
    }
}

interface PagingRepositoryCallback {
    fun getDataItem(application: Application): LiveData<PagedList<DataItem>>
}