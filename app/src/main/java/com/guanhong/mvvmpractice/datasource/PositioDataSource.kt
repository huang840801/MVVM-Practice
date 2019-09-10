package com.guanhong.mvvmpractice.datasource

import androidx.paging.PositionalDataSource
import com.guanhong.mvvmpractice.response.player.DataItem

class PositioDataSource: PositionalDataSource<DataItem>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<DataItem>) {

    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<DataItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}