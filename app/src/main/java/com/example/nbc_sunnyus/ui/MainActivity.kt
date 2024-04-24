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
    //tab목록 리스트로 묶기
    private val tabTitleArray = arrayOf("전화번호부", "마이페이지")

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //initViewPager() 사용안함

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

        }


        //플러팅 버튼 누르면 다이얼로그
        binding.floatingbtnMain.setOnClickListener {

        }
    }
}
