package com.example.nbc_sunnyus.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    //private val tabTitleArray = arrayOf("First", "second")
    //var fragments: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return ContactListFragment()
            else -> return MyPageFragment()
        }
    }

    //fragment 추가
    /*fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    //fragment 제거
    fun removeFragment() {
        fragments.removeLast()
        notifyItemInserted(fragments.size)
    }*/
}