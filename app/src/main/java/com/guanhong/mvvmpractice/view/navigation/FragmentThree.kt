package com.guanhong.mvvmpractice.view.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.guanhong.mvvmpractice.R
import kotlinx.android.synthetic.main.fragment_navigation_three.*

class FragmentThree : Fragment() {

    private var title: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_navigation_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            title = it.getString("titleKey")
        }

        textView.text = title

        textView.setOnClickListener {

            Navigation.findNavController(it).navigateUp()
        }
    }
}