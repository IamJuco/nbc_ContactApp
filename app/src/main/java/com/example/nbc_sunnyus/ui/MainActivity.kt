package com.example.nbc_sunnyus.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbc_sunnyus.R
import com.example.nbc_sunnyus.databinding.ActivityMainBinding
import com.example.nbc_sunnyus.model.UserInfo
//import com.example.nbc_sunnyus.model.UserInfo
import com.example.nbc_sunnyus.util.Constants
import com.example.nbc_sunnyus.util.Constants.KEY_USER

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //임시 코드
        binding.btn.setOnClickListener {
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra(KEY_USER, UserInfo::class.java)
            startActivity(intent)
        }
    }
}