package com.example.nbc_sunnyus.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbc_sunnyus.R
import com.example.nbc_sunnyus.databinding.ActivityContactDetailBinding
import com.example.nbc_sunnyus.model.UserInfo
import com.example.nbc_sunnyus.util.Constants

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class ContactDetailActivity : AppCompatActivity() {

    private val binding: ActivityContactDetailBinding by lazy {
        ActivityContactDetailBinding.inflate(layoutInflater)
    }

    private lateinit var userInfo: UserInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpData()

        setUpListener()
    }

    private fun setUpData() {
        // ContactListFragment로부터 받은 데이터에 접근
        userInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            intent?.getParcelableExtra(Constants.KEY_USER, UserInfo::class.java)!!
        } else {
            intent?.getParcelableExtra(Constants.KEY_USER)!!
        }

        // 받은 데이터를 이미지 뷰 및 텍스트 뷰에 설정
        userInfo.let {
            binding.ivImage.setImageResource(it.image)
            binding.tvName.text = it.name
            binding.tvPhoneNumberData.text = it.phoneNumber
            binding.tvEmailData.text = it.email
            binding.tvTeamData.text = it.team
        }
    }

    private fun setUpListener() {

        // 플로팅 버튼 클릭하여 다이얼로그 띄우기
        binding.btnFloating.setOnClickListener {
            // TODO
        }

        // 뒤로 가기 버튼(화면)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    // 뒤로 가기 버튼(디바이스)
    // 싱글턴 객체로 ContactList에 데이터를 전달하므로 finish 처리
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}