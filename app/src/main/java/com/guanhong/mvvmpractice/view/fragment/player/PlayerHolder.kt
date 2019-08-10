package com.guanhong.mvvmpractice.view.fragment.player

import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.databinding.ItemPlayerProfileBinding
import com.guanhong.mvvmpractice.response.player.DataItem

class PlayerHolder(private val binding: ItemPlayerProfileBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setResult(dataItem: DataItem) {

        binding.dataItem = dataItem
        binding.executePendingBindings()
    }
}