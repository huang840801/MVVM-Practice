package com.guanhong.mvvmpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guanhong.mvvmpractice.R

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_second, container,false)
    }

    fun newInstance(): SecondFragment {
        return SecondFragment()
    }
}