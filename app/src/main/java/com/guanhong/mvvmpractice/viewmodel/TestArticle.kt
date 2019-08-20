package com.guanhong.mvvmpractice.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class TestArticle : BaseObservable() {

    @Bindable
    var title: String = ""
    @Bindable
    var content: String = ""
    @Bindable
    var color: Long = 0

    fun updateTitle(title: String) {

        this.title = title
        notifyPropertyChanged(BR.title)
//        notifyChange()
    }

    fun updateData(title: String, content: String) {

        this.content = content
        this.title = title

        color = 0XFF2196F3
        notifyPropertyChanged(BR.title)

        notifyChange()
    }
}