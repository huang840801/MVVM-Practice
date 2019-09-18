package com.guanhong.mvvmpractice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.database.DataItemDbHelper
import com.guanhong.mvvmpractice.databinding.ActivityMainBinding
import com.guanhong.mvvmpractice.extension.showToast
import com.guanhong.mvvmpractice.factory.MainViewModelFactory
import com.guanhong.mvvmpractice.repository.MainRepository
import com.guanhong.mvvmpractice.view.navigation.NavigationActivity
import com.guanhong.mvvmpractice.view.paging.PagingActivity
import com.guanhong.mvvmpractice.viewmodel.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MainViewModelFactory(MainRepository(), application)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

//        viewModel = ViewModelProviders.
//        val factory = MainViewModelFactory().

//        binding 的第一種方法
//        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
//        binding = ActivityMainBinding.bind(rootView)
//        setContentView(binding.root)

//        binding 的第二種方法
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this    // set lifecycle owner for Livedata in xml
        binding.viewModel = viewModel

        viewModel.init()

        val dao = DataItemDbHelper(this)

        GlobalScope.launch {
            Log.d("Huang", " dataItem in db count = " + dao.getRoomDataItemDao().getAll().count())
        }
    }

    fun onViewClick(view: View) {

        when (view) {
            is TextView -> {
                showToast(this, view.text.toString())
            }
        }
    }

    fun onProfileBtnClick(view: View) {

//        val intent = Intent(this, ProfileActivity::class.java)
//        val intent = Intent(this, SpinnerSampleActivity::class.java)
//        val intent = Intent(this, TimerActivity::class.java)
//        val intent = Intent(this, LiveDataActivity::class.java)
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }

    fun onItemKeyBtnClick(view: View) {

        val intent = Intent(this, PagingActivity::class.java)
        startActivity(intent)
    }

    fun onPagingKeyBtnClick(view: View) {

        val intent = Intent(this, PagingActivity::class.java)
        startActivity(intent)
    }
}
