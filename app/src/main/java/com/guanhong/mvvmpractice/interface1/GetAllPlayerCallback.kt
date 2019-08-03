package com.guanhong.mvvmpractice.interface1

import com.guanhong.mvvmpractice.response.player.DataItem

interface GetAllPlayerCallback {

    fun onSuccess(dataItemList: List<DataItem>)
}