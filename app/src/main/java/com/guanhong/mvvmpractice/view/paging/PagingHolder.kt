package com.guanhong.mvvmpractice.view.paging

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val name: TextView = itemView.findViewById(R.id.name)
    val feet: TextView = itemView.findViewById(R.id.feet)

    fun setResult(item: DataItem) {

        name.text = item.firstName
        feet.text = item.heightFeet.toString()
    }
}