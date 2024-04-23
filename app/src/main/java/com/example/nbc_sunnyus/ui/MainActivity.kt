package com.example.nbc_sunnyus.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.nbc_sunnyus.R
import com.example.nbc_sunnyus.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    //tab목록 리스트로 묶기 ?
    private val tabTitleArray = arrayOf("전화번호부", "마이페이지")

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /*
        //프레그먼트
        val myPageFragment = MyPageFragment()
        val contactListFragment = ContactListFragment()

        val fragments = arrayListOf<Fragment>(myPageFragment, contactListFragment)


        //tab 어뎁터
        val tabAdapter = object : FragmentStateAdapter(this) {
            //fragment 사이즈
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

        }*/

    private fun initViewPager() {
        //ViewPager Adapter 생성
        /*var viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2Adapter.addFragment(ContactListFragment()) //연락처 Fragment 추가
        viewPager2Adapter.addFragment(MyPageFragment()) // 마이패이지 Fragment 추가*/

        //Adapter 연결
        /*binding.apply {
            viewpager2Main.adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(tablayoutMain, viewpager2Main) { tab, position
                tab.text = tabTitleList[position]
            }
        }*/

        /*binding.viewpager2Main.apply {
            adapter = viewPager2Adapter

            registerOnPageChangeCallBack(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }*/

        //ViewPager TabLayout 연결
        /*TabLayoutMeditaor(binding.tablayoutMain, binding.viewpager2Main) { tab, position ->
            when (position) {
                //
                0 -> tab
                1 -> tab
            }
        }.attach()*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //initViewPager()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Adapter 연결
        binding.apply {
            viewpager2Main.adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(tablayoutMain, viewpager2Main) { tab, position ->
                tab.text = tabTitleArray[position]
            }.attach()

            //viewPager2
            val viewPager2: ViewPager2 = binding.viewpager2Main

        }

        /*private fun setTabLayout() {

        binding.tablayoutMain.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            //tab이 선택되었을 때 : position에 따라
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {

                    }
                }

            }

            //tab이 선택되지 않았을 때
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            //tab이 다시 선택되었을 때
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }*/
    }
}
