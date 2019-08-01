package com.guanhong.mvvmpractice.view.fragment.second

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.response.player.DataItem

class SecondHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name:TextView = itemView.findViewById(R.id.name)

    fun setResource(): RecyclerView.ViewHolder {
        return this
    }

    fun setResult(dataItem: DataItem) {

        name.text = dataItem.firstName
    }
}