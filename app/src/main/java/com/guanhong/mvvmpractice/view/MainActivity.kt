package com.guanhong.mvvmpractice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivityMainBinding
import com.guanhong.mvvmpractice.extension.showToast
import com.guanhong.mvvmpractice.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        binding 的第一種方法
//        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
//        binding = ActivityMainBinding.bind(rootView)
//        setContentView(binding.root)

//        binding 的第二種方法
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this    // set lifecycle owner for Livedata in xml
        binding.viewModel = viewModel

        viewModel.init()
    }

    fun onViewClick(view: View) {

        when (view) {
            is TextView -> {
                showToast(this, view.text.toString())
            }
        }
    }

    fun onProfileBtnClick(view: View) {

        val intent = Intent(this, ProfileActivity::class.java)
//        val intent = Intent(this, SpinnerSampleActivity::class.java)
//        val intent = Intent(this, TestActivity::class.java)
//        val intent = Intent(this, LiveDataActivity::class.java)
        startActivity(intent)
    }
}
