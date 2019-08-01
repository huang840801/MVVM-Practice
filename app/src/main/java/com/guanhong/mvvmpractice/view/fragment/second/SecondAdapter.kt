package com.guanhong.mvvmpractice.view.fragment.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.response.player.DataItem

class SecondAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList: List<DataItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player_profile, parent, false)
        val holder = SecondHolder(view)
        return holder.setResource()
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is SecondHolder -> {
                holder.setResult(dataList[position])
            }
        }
    }

    fun bindDataList(dataList: List<DataItem>) {

        this.dataList = dataList
        notifyDataSetChanged()
    }
}