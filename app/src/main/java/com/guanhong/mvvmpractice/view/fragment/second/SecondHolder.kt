package com.guanhong.mvvmpractice.view.fragment.second

import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.databinding.ItemPlayerProfileBinding
import com.guanhong.mvvmpractice.response.player.DataItem

class SecondHolder(private val binding: ItemPlayerProfileBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setResult(dataItem: DataItem) {

        binding.dataItem = dataItem
        binding.executePendingBindings()
    }
}