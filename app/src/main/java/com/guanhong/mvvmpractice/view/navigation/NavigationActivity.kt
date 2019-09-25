package com.guanhong.mvvmpractice.view.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.guanhong.mvvmpractice.R

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        Log.d("Huang", " onCreate")

        val data: Uri? = intent?.data

        Log.d("Huang", " data " + data)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d("Huang", " onNewIntent")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Huang", " onResume")
    }

    override fun onSupportNavigateUp(): Boolean {

        return findNavController(R.id.my_nav_host_fragment).navigateUp()
    }
}