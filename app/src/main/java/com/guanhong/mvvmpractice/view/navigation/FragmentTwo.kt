package com.guanhong.mvvmpractice.view.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.guanhong.mvvmpractice.R
import kotlinx.android.synthetic.main.fragment_navigation_two.*

class FragmentTwo : Fragment(), FragmentTwoAdapter.FragmentTwoAdapterListener {

    private lateinit var adapter: FragmentTwoAdapter

    private var args: String? = null
    private val stringList = listOf("111", "222", "333", "444", "555")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Huang"," FragmentTwo onCreate")

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Huang"," FragmentTwo onCreateView")

        return inflater.inflate(R.layout.fragment_navigation_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FragmentTwoAdapter(this)
        recyclerView.adapter = adapter

        adapter.setStringList(stringList)

        arguments?.let {
            args = it.getString("key")
        }

        textView.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_page3)
        }
    }

    override fun itemClick(title: String) {

        val bundle = Bundle()

        bundle.putString("titleKey", title)

        findNavController().navigate(R.id.action_page3, bundle)
    }
}