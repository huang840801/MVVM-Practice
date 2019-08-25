package com.guanhong.mvvmpractice.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class SpinnerViewModel {

    val editTextContent = ObservableField<String>()

    val parentList = ObservableField<List<String>>()
    val subList = ObservableField<List<String>>()

    val selectedPosition = ObservableInt()

    val contentList: MutableList<List<String>> = mutableListOf()

    init {

        val titleList: MutableList<String> = mutableListOf()
        titleList.add("Android")
        titleList.add("IOS")
        val contentList1: MutableList<String> = mutableListOf()
        contentList1.add("Java")
        contentList1.add("Kotlin")
        val contentList2: MutableList<String> = mutableListOf()
        contentList2.add("Objective-C")
        contentList2.add("Swift")

        contentList.add(contentList1)
        contentList.add(contentList2)

        this.parentList.set(titleList)
        selectedPosition.set(0)
        subList.set(contentList1)

        selectedPosition.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                subList.set(contentList[selectedPosition.get()])

            }
        })
    }
}