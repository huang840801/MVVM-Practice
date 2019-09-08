package com.guanhong.mvvmpractice.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.guanhong.mvvmpractice.response.player.DataItem

class DataSourceFactory :
    DataSource.Factory<String, DataItem>() {

    private val sourceLiveData = MutableLiveData<PagingDataSource>()

    override fun create(): DataSource<String, DataItem> {
        val source = PagingDataSource()
        sourceLiveData.postValue(source)
        return source
    }
}