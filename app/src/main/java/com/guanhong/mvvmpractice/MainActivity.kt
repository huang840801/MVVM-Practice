package com.guanhong.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val user1 = User("Jordan", "23")
        val user2 = User("James", "6")

        Handler().postDelayed({

            binding.user = user2
            binding.userId

        },3000)

        binding.user = user1
    }
}
