package com.guanhong.mvvmpractice

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl:String){

    Glide.with(imageView.context)
        .load(imageUrl)
        .into(imageView)
}