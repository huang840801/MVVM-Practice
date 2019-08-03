package com.guanhong.mvvmpractice.view.fragment.second

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guanhong.mvvmpractice.databinding.ItemPlayerProfileBinding
import com.guanhong.mvvmpractice.response.funny.Tupian
import com.guanhong.mvvmpractice.response.player.DataItem

class SecondHolder(private val binding: ItemPlayerProfileBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setAllPlayerResult(dataItem: DataItem) {

        Glide.with(binding.root.context).load(dataItem.imageUrl).into(binding.image)
        binding.dataItem = dataItem
        binding.executePendingBindings()
    }

    fun setTupianResult(tupian: Tupian) {

        binding.tupian = tupian
        binding.executePendingBindings()
    }
}