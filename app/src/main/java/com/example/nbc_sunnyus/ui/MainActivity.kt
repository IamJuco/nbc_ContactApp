package com.example.nbc_sunnyus.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbc_sunnyus.R
import com.example.nbc_sunnyus.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    //tab 목록 리스트로 묶기
    private val tabTitleArray = arrayOf("연락처", "마이페이지")

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Adapter 연결
        binding.apply {
            viewpager2Main.adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(tablayoutMain, viewpager2Main) { tab, position ->
                when (position) {
                    0 -> tab.icon =
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.tab_contactcall)

                    1 -> tab.icon =
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.tab_mypage)
                }
                tab.text = tabTitleArray[position]
            }.attach()

        }

    }
}
