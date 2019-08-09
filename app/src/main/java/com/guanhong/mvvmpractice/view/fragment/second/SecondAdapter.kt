package com.guanhong.mvvmpractice.view.fragment.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.databinding.ItemPlayerProfileBinding
import com.guanhong.mvvmpractice.response.player.DataItem

class SecondAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var allPlayerDataList: List<DataItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayerProfileBinding.inflate(layoutInflater, parent, false)
        return SecondHolder(binding)
    }

    override fun getItemCount(): Int = allPlayerDataList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is SecondHolder -> {
                holder.setAllPlayerResult(allPlayerDataList[position])
            }
        }
    }

    fun bindAllPlayerDataList(allPlayerDataList: List<DataItem>) {

        this.allPlayerDataList = allPlayerDataList
        notifyDataSetChanged()
    }
}