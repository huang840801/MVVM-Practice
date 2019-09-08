package com.guanhong.mvvmpractice.view.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.response.player.DataItem

class PagingAdapter : PagedListAdapter<DataItem, PagingHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_paging, parent, false)

        return PagingHolder(view)
    }

    override fun onBindViewHolder(holder: PagingHolder, position: Int) {

        val data = getItem(position)

        data?.let {
            holder.setResult(data)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataItem>() {

        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }
    }
}