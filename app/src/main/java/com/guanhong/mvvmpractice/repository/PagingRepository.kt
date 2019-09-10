package com.guanhong.mvvmpractice.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.guanhong.mvvmpractice.datasource.DataSourceFactory
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingRepository : PagingRepositoryCallback {

    private val sourceFactory by lazy {
        DataSourceFactory()
    }

    override fun getDataItem(): LiveData<PagedList<DataItem>> {

        val pagedListConfig =
            PagedList.Config.Builder().setPageSize(10).setPrefetchDistance(4).build()
    }
}

interface PagingRepositoryCallback {
    fun getDataItem(): LiveData<PagedList<DataItem>>
}