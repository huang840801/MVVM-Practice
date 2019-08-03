package com.guanhong.mvvmpractice.view.fragment.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.FragmentFirstBinding
import com.guanhong.mvvmpractice.interface1.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = LayoutInflater.from(context).inflate(R.layout.fragment_first, null)
        binding = FragmentFirstBinding.bind(rootView)

        return rootView

//        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllPlayer()
    }

    fun newInstance(): FirstFragment {
        return FirstFragment()
    }

    private fun getAllPlayer() {

        val repository = MainRepository()
        repository.getAllPlayer(object : GetAllPlayerCallback {
            override fun onSuccess(dataItemList: List<DataItem>) {
                binding.dataItem = dataItemList[0]
            }
        })
    }
}