package com.example.nbc_sunnyus.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbc_sunnyus.data.dummyItem
import com.example.nbc_sunnyus.databinding.FragmentContactListBinding
import com.example.nbc_sunnyus.util.Constants

class ContactListFragment : Fragment() {

    private lateinit var binding: FragmentContactListBinding

    private lateinit var contactListAdapter: ContactListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData() // 데이터 초기 값
        setUpView() // 초기 뷰 설정 (뷰가 터치된 상태 등)
        setRecyclerView()
        setUpListener() // 리스너를 모아두는곳 (클릭리스너 등)

    }

    private fun setUpData() {
//        TODO("Not yet implemented")
    }

    private fun setUpView() {
//        TODO("Not yet implemented")
    }

    private fun setUpListener() {
        contactListAdapter.setItemClickListener(object : ContactListAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val item = contactListAdapter.getItem(position)
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(Constants.KEY_USER, item)
                startActivity(intent)
            }
        })
    }

    private fun setRecyclerView() {
        contactListAdapter = ContactListAdapter(dummyItem)
        binding.rvMain.adapter = contactListAdapter
    }
}