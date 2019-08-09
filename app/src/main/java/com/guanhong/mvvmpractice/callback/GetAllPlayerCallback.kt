package com.guanhong.mvvmpractice.callback

import com.guanhong.mvvmpractice.response.player.DataItem

interface GetAllPlayerCallback {

    fun onSuccess(dataItemList: List<DataItem>)
}