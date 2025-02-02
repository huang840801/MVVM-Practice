package com.guanhong.mvvmpractice.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.guanhong.mvvmpractice.response.player.DataItem

class DataSourceFactory :
    DataSource.Factory<Int, DataItem>() {

//    private val sourceLiveData = MutableLiveData<PagingKeyDataSource>()
    private val sourceLiveData = MutableLiveData<ItemKeyDataSource>()

    override fun create(): DataSource<Int, DataItem> {

//        val source = PagingKeyDataSource()
//        sourceLiveData.postValue(source)
        val source = ItemKeyDataSource()
        sourceLiveData.postValue(source)

        return source
    }
}