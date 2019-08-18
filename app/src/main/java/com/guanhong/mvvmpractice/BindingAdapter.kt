package com.guanhong.mvvmpractice

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guanhong.mvvmpractice.response.player.DataItem
import com.guanhong.mvvmpractice.view.fragment.player.PlayerAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String) {

    Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
}

@BindingAdapter("visibility")
fun bindVisibility(view: View, isShow: Boolean) {

    view.visibility = if (isShow) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

@BindingAdapter("playerItems")
fun bindRecyclerViewWithDataItemList(recyclerView: RecyclerView, dataItemList: List<DataItem>?) {
    dataItemList?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is PlayerAdapter -> submitList(it)
            }
        }
    }
}

@BindingAdapter("spinnerList")
fun setSpinnerList(spinner: Spinner, contentList: ObservableField<List<String>>) {

    val adapter = ArrayAdapter(spinner.context,
            android.R.layout.simple_spinner_dropdown_item,
            contentList.get()!!)
    spinner.adapter = adapter

}


@BindingAdapter("selectionPosition")
fun setSpinnerSelectionPosition(spinner: Spinner, selectPosition: Int) {
    spinner.setSelection(selectPosition)
}


@InverseBindingAdapter(attribute = "selectionPosition")
fun getSpinnerSelectionPosition(spinner: Spinner): Int {
    return spinner.selectedItemPosition
}


@BindingAdapter("selectionPositionAttrChanged")
fun setSpinnerOnChangeListener(spinner: Spinner, listener: InverseBindingListener) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            listener.onChange()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }
}