package com.guanhong.mvvmpractice.view.fragment.test2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.viewmodel.TestFragmentViewModel
import kotlinx.android.synthetic.main.fragment_test_2.*

class Test2Fragment : Fragment() {

    lateinit var viewModel: TestFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_test_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProviders.of(activity!!).get(TestFragmentViewModel::class.java)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(TestFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModel.name.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {

                textview.text = t
            }
        })
    }

    fun newInstance(): Test2Fragment {
        return Test2Fragment()
    }
}