package com.guanhong.mvvmpractice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivityTestBinding
import com.guanhong.mvvmpractice.viewmodel.TestArticle
import com.guanhong.mvvmpractice.viewmodel.TestViewModel
import java.util.*

class TestActivity : AppCompatActivity() {

    lateinit var binding: ActivityTestBinding
    lateinit var viewModel: TestViewModel
    lateinit var article: TestArticle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = TestViewModel()
        article = TestArticle()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)

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
