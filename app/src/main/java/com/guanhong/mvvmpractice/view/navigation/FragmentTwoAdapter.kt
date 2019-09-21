package com.guanhong.mvvmpractice.view.navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.mvvmpractice.R

class FragmentTwoAdapter(private val listener: FragmentTwoAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    FragmentTwoHolder.FragmentTwoHolderListener {

    interface FragmentTwoAdapterListener {
        fun itemClick(title: String)
    }

    override fun itemClick(title: String) {
        listener.itemClick(title)
    }

    private var stringList = listOf<String>()

    override fun getItemCount(): Int = stringList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fragment_two, parent, false)
        return FragmentTwoHolder(view, this)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is FragmentTwoHolder -> {

                holder.setResult(stringList[position])
            }
        }
    }

    fun setStringList(stringList: List<String>) {

        this.stringList = stringList
        notifyDataSetChanged()
    }
}

class FragmentTwoHolder(itemView: View, private val listener: FragmentTwoHolderListener) :
    RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.title)

    interface FragmentTwoHolderListener {
        fun itemClick(title: String)
    }

    fun setResult(title: String) {
        this.title.text = title

        this.title.setOnClickListener {

            listener.itemClick(title)
        }
    }
}