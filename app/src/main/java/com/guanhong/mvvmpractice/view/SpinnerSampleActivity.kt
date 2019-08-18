package com.guanhong.mvvmpractice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivitySpinnerSampleBinding
import com.guanhong.mvvmpractice.viewmodel.SpinnerViewModel

class SpinnerSampleActivity : AppCompatActivity() {

    private lateinit var viewModel: SpinnerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = SpinnerViewModel()

        val binding = DataBindingUtil.setContentView<ActivitySpinnerSampleBinding>(this, R.layout.activity_spinner_sample)
        binding.viewModel = viewModel
        setContentView(binding.root)
    }
}