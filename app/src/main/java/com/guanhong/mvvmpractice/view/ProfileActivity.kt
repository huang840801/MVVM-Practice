package com.guanhong.mvvmpractice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.guanhong.mvvmpractice.R
import com.guanhong.mvvmpractice.view.fragment.first.FirstFragment
import com.guanhong.mvvmpractice.view.fragment.second.SecondFragment
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment

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
        secondFragment = SecondFragment().newInstance()

        fragmentList.add(firstFragment)
        fragmentList.add(secondFragment)
    }
}

class ViewPagerAdapter(fragmentManager: FragmentManager,
                       private val fragmentList: List<Fragment>)
    : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.count()

}