package com.guanhong.mvvmpractice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivityTimerBinding
import com.guanhong.mvvmpractice.viewmodel.TestArticle
import com.guanhong.mvvmpractice.viewmodel.TimerViewModel
import java.util.*

class TimerActivity : AppCompatActivity() {

    lateinit var binding: ActivityTimerBinding
    lateinit var viewModel: TimerViewModel
    lateinit var article: TestArticle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = TimerViewModel()
        article = TestArticle()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_timer)

        binding.viewModel = viewModel
        binding.article = article

        var num = 0

        Timer().schedule(object : TimerTask() {
            override fun run() {

                article.upDateNum(num++)
            }

        }, 0, 2000)
    }
}
