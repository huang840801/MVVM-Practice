package com.guanhong.mvvmpractice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.databinding.ActivityMainBinding
import com.guanhong.mvvmpractice.interface1.GetAllPlayerCallback
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.response.player.DataItem

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding 的第一種方法
//        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
//        binding = ActivityMainBinding.bind(rootView)
//        setContentView(binding.root)

//        binding 的第二種方法
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getAllPlayer()
    }

    fun onViewClick(view: View) {

        when (view) {
            is TextView -> {
                showToast(view.text.toString())
            }
        }
    }

    fun onProfileBtnClick(view: View) {

        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)

    }

    private fun getAllPlayer() {

        val repository = MainRepository()

        repository.getAllPlayer(object : GetAllPlayerCallback {
            override fun onSuccess(dataItemList: List<DataItem>) {
                binding.dataItem = dataItemList[0]
            }
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
