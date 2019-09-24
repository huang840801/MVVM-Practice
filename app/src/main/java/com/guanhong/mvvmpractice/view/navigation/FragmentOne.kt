package com.guanhong.mvvmpractice.view.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.guanhong.mvvmpractice.R
import kotlinx.android.synthetic.main.fragment_navigation_one.*

class FragmentOne : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Huang"," FragmentOne onCreate ")

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Huang"," FragmentOne onCreateView")

        return inflater.inflate(R.layout.fragment_navigation_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_page2)
        }

        val extras = FragmentNavigatorExtras(
            catImageView to "catImage",
            textView to "catText"
        )

        val bundle = Bundle()

        bundle.putString("key"," testValue")
        catImageView.setOnClickListener {

            findNavController().navigate(R.id.action_page2, bundle,NavOptions.Builder().setLaunchSingleTop(true).build(), extras)

//            Navigation.findNavController(it).navigate(R.id.action_page2, bundle, null, extras)
        }
    }
}