package com.example.nbc_sunnyus.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbc_sunnyus.data.dummyItem
import com.example.nbc_sunnyus.databinding.FragmentContactListBinding
import com.example.nbc_sunnyus.model.UserInfo
import com.example.nbc_sunnyus.util.Constants

class ContactListFragment : Fragment() {

    private lateinit var binding: FragmentContactListBinding

    private lateinit var contactListAdapter: ContactListAdapter

    private val userInfo by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList(Constants.KEY_USER, UserInfo::class.java)
        } else {
            arguments?.getParcelableArrayList(Constants.KEY_USER)
        }
    }

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
        setUpData()
        setRecyclerView()
        setUpListener() // 리스너를 모아두는곳 (클릭리스너 등)
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

    private fun setUpData() {
        userInfo?.let { fetchData(it) }
    }

    private fun fetchData(data: List<UserInfo>) {
        contactListAdapter = ContactListAdapter(data)
        binding.rvMain.adapter = contactListAdapter
    }

    private fun setRecyclerView() {
        contactListAdapter = ContactListAdapter(dummyItem)
        binding.rvMain.adapter = contactListAdapter
    }
}