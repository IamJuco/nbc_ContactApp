package com.example.nbc_sunnyus.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyPageFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpData() // 데이터 초기 값
        setUpView() // 초기 뷰 설정 (뷰가 터치된 상태 등)
        setUpListener() // 리스너를 모아두는곳 (클릭리스너 등)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun setUpData() {
        TODO("Not yet implemented")
    }

    private fun setUpView() {
        TODO("Not yet implemented")
    }

    private fun setUpListener() {
        TODO("Not yet implemented")
    }
}