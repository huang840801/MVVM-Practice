package com.guanhong.mvvmpractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.guanhong.mvvmpractice.repository.PagingRepository

class PagingViewModel(repository: PagingRepository, application: Application) :
    AndroidViewModel(application) {

    val pagedListLiveData = repository.getDataItem(application)
}

