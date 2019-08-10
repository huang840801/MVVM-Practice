package com.guanhong.mvvmpractice

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
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