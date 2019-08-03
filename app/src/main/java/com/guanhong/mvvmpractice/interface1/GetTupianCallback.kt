package com.guanhong.mvvmpractice.interface1

import com.guanhong.mvvmpractice.response.funny.Tupian

interface GetTupianCallback {

    fun onSuccess(tupianList: List<Tupian>)
}