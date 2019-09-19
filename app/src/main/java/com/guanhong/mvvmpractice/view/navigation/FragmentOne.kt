package com.guanhong.mvvmpractice.view.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.guanhong.mvvmpractice.R
import kotlinx.android.synthetic.main.fragment_navigation_one.*

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
        catImageView.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_page2, null, null, extras)
        }
    }
}