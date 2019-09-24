package com.guanhong.mvvmpractice.view.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.guanhong.mvvmpractice.R
import kotlinx.android.synthetic.main.fragment_blank_fragment2.*

class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Huang", " BlankFragment2 onCreateView")

        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Huang", " BlankFragment2 onViewCreated")

        textView.setOnClickListener {

            findNavController().navigate(R.id.action_blankFragment2_to_blankFragment1)
        }
    }
}
