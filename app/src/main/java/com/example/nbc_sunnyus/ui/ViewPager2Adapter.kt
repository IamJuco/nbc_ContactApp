package com.example.nbc_sunnyus.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    //페이지 개수
    override fun getItemCount(): Int = NUM_TABS

    //파라미터: position값, 반환값: Fragment
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ContactListFragment()
            else -> MyPageFragment()
        }
    }

    companion object {
        private const val NUM_TABS = 2     //key 값 (사용법 : TabNumbers.NUM_TABS 로 접근 가능)
    }
}
