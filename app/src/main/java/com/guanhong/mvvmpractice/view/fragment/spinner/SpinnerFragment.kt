package com.guanhong.mvvmpractice.view.fragment.spinner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guanhong.mvvmpractice.databinding.FragmentSpinnerBinding
import com.guanhong.mvvmpractice.viewmodel.SpinnerViewModel

class SpinnerFragment : Fragment() {

    lateinit var binding: FragmentSpinnerBinding
    lateinit var viewModel: SpinnerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSpinnerBinding.inflate(inflater, container, false)
        viewModel = SpinnerViewModel()
        binding.viewModel = viewModel

        return binding.root

//        original code
//        return inflater.inflate(R.layout.fragment_spinner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllPlayer()
    }

    fun newInstance(): SpinnerFragment {
        return SpinnerFragment()
    }

    private fun getAllPlayer() {

//        val repository = MainRepository()
//        repository.getAllPlayer(object : GetAllPlayerCallback {
//            override fun onSuccess(dataItemList: List<DataItem>) {
//                binding.dataItem = dataItemList[0]
//            }
//        })
    }
}