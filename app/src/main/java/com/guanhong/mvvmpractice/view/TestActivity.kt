package com.guanhong.mvvmpractice.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivityTestBinding
import com.guanhong.mvvmpractice.viewmodel.TestArticle
import com.guanhong.mvvmpractice.viewmodel.TestViewModel

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

        Handler().postDelayed({
//            viewModel.updateUserName("James 0 ")
            article.updateData("111","aaa")

        }, 2000)
        Handler().postDelayed({
//            viewModel.updateUserName("James 1 ")
            article.updateData("222","bbb")


        }, 4000)
        Handler().postDelayed({
//            viewModel.updateUserName("James 2 ")
            article.updateData("333","ccc")

        }, 6000)
//        viewModel.updateCityList()
    }

}
