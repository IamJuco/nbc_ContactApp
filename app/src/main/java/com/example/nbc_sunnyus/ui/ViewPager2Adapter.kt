package com.example.nbc_sunnyus.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    //페이지 개수
    override fun getItemCount(): Int = NUM_TABS

    //파라미터: position값, 반환값: Fragment
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return ContactListFragment()
            else -> return MyPageFragment()
        }
    }
}