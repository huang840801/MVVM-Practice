package com.guanhong.mvvmpractice.view.paging

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.factory.PagingViewModelFactory
import com.guanhong.mvvmpractice.repository.PagingRepository
import com.guanhong.mvvmpractice.viewmodel.PagingViewModel
import kotlinx.android.synthetic.main.activity_paging.*

class PagingActivity : AppCompatActivity() {

    lateinit var viewModel: PagingViewModel
    lateinit var adapter: PagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging)

        val factory = PagingViewModelFactory(PagingRepository(), application)
        viewModel = ViewModelProviders.of(this,factory).get(PagingViewModel::class.java)
        adapter = PagingAdapter()
        recyclerView.adapter = adapter


        viewModel.pagedListLiveData.observe(this, Observer {

            Log.d("Huang"," PagingActivity "+it.count())

            adapter.submitList(it)

        })
    }
}