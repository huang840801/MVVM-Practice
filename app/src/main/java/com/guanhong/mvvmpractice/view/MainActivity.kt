package com.guanhong.mvvmpractice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivityMainBinding
import com.guanhong.mvvmpractice.response.player.DataItem
import com.guanhong.mvvmpractice.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding 的第一種方法
//        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
//        binding = ActivityMainBinding.bind(rootView)
//        setContentView(binding.root)

//        binding 的第二種方法
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this    // set lifecycle owner for Livedata in xml

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

//        viewModel.getDataItem().observe(this,
//            Observer<DataItem> { dataItem ->
//
//                            Log.d("Huang", " Observer "+ dataItem.firstName)
//
//                viewModel.dataItem.value = dataItem })


        viewModel.test.observe(this,
            Observer<String> { test ->

                            Log.d("Huang", " Observer "+ test)

                name.text = test
//                viewModel.dataItem.value = test
            })

        viewModel.Test()


//        viewModel.init()

    }

    fun onViewClick(view: View) {

        when (view) {
            is TextView -> {
                showToast(view.text.toString())
            }
        }
    }

    fun onProfileBtnClick(view: View) {

        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
