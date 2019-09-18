package com.guanhong.mvvmpractice.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.guanhong.mvvmpractice.R

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }

    override fun onSupportNavigateUp(): Boolean {

       return findNavController(R.id.my_nav_host_fragment).navigateUp()
    }
}