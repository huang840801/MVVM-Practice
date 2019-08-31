package com.guanhong.mvvmpractice.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.extension.showToast
import com.guanhong.mvvmpractice.viewmodel.LiveDataViewModel
import java.util.*

class LiveDataActivity : AppCompatActivity() {

    lateinit var viewModel: LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activtiy_live_data)

        viewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)

//        viewModel.name.observe(this,
//            Observer<String> { t ->
//
//                showToast(this, t)
//                text1.text = t
//            })

        viewModel.num.observe(this, Observer {
            t ->
            showToast(this, t.toString())

        })

        var num = 0

        Timer().schedule(object : TimerTask() {
            override fun run() {

                viewModel.upDateNum(num++)
            }

        }, 0, 7000)

//        Handler().postDelayed({
//
//            viewModel.init()
//        }, 3000)
    }
}