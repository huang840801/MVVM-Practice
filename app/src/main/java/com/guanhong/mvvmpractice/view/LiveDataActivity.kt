package com.guanhong.mvvmpractice.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.extension.showToast
import com.guanhong.mvvmpractice.viewmodel.LiveDataViewModel
import kotlinx.android.synthetic.main.activtiy_live_data.*

class LiveDataActivity : AppCompatActivity() {

    lateinit var viewModel: LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activtiy_live_data)

        viewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)

        viewModel.name.observe(this,
            Observer<String> { t ->

                showToast(this, t)
                text1.text = t
            })

        Handler().postDelayed({

//            showToast(this, "Wade")
//            text1.text = "Wade"
            viewModel.init()
        }, 3000)
    }
}