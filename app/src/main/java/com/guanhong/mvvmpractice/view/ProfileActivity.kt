package com.guanhong.mvvmpractice.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.database.RoomDbHelper
import com.guanhong.mvvmpractice.view.fragment.spinner.SpinnerFragment
import com.guanhong.mvvmpractice.view.fragment.player.PlayerFragment
import com.guanhong.mvvmpractice.view.fragment.test1.Test1Fragment
import com.guanhong.mvvmpractice.view.fragment.test2.Test2Fragment
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {

    private lateinit var spinnerFragment: SpinnerFragment
    private lateinit var playerFragment: PlayerFragment
    private lateinit var test1Fragment: Test1Fragment
    private lateinit var test2Fragment: Test2Fragment

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initFragment()
        setupViewPager()

        val db = RoomDbHelper(this)

        GlobalScope.launch {
            val data = db.getRoomDao().getAll()

            data.forEach {
                Log.d("Huang", " id = "+it.id)
                Log.d("Huang", " name = "+it.name)
                Log.d("Huang", " time = "+it.time)
            }
        }
    }

    private fun setupViewPager() {

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragmentList)
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = viewPagerAdapter
    }

    private fun initFragment() {

//        spinnerFragment = SpinnerFragment().newInstance()
//        playerFragment = PlayerFragment().newInstance()
//
//        fragmentList.add(playerFragment)
//        fragmentList.add(spinnerFragment)
//
        test1Fragment = Test1Fragment().newInstance()
        test2Fragment = Test2Fragment().newInstance()

        fragmentList.add(test1Fragment)
        fragmentList.add(test2Fragment)
    }
}

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    private val fragmentList: List<Fragment>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.count()
}