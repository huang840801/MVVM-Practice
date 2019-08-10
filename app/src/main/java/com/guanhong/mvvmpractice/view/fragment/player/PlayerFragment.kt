package com.guanhong.mvvmpractice.view.fragment.player

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.guanhong.mvvmpractice.databinding.FragmentPlayerBinding
import com.guanhong.mvvmpractice.viewmodel.PlayerFragmentViewModel
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : Fragment() {

    lateinit var binding: FragmentPlayerBinding
    lateinit var adapter: PlayerAdapter
    lateinit var viewModel: PlayerFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = PlayerFragmentViewModel()

        binding = FragmentPlayerBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.recyclerView.adapter = PlayerAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PlayerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        getAllPlayer()
    }

    fun newInstance(): PlayerFragment {
        return PlayerFragment()
    }

    private fun getAllPlayer() {

        viewModel.init()
//        val repository = MainRepository()
//        repository.getAllPlayer(object : GetAllPlayerCallback {
//            override fun onSuccess(dataItemList: List<DataItem>) {
//                adapter.bindAllPlayerDataList(dataItemList)
//            }
//        })
    }
}