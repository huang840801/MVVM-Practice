package com.guanhong.mvvmpractice.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.view.fragment.first.FirstFragment
import com.guanhong.mvvmpractice.view.fragment.player.PlayerFragment
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var firstFragment: FirstFragment
    private lateinit var playerFragment: PlayerFragment

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initFragment()
        setupViewPager()
    }

    private fun setupViewPager() {

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragmentList)
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = viewPagerAdapter
    }

    private fun initFragment() {

        firstFragment = FirstFragment().newInstance()
        playerFragment = PlayerFragment().newInstance()

        fragmentList.add(playerFragment)
        fragmentList.add(firstFragment)
    }
}

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    private val fragmentList: List<Fragment>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.count()
}