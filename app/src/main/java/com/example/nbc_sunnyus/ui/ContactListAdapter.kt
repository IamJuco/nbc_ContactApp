package com.example.nbc_sunnyus.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sunnyus.R
import com.example.nbc_sunnyus.databinding.RecyclerviewEvenBinding
import com.example.nbc_sunnyus.databinding.RecyclerviewOddBinding
import com.example.nbc_sunnyus.model.UserInfo
import java.lang.Exception

class ContactListAdapter (private val items: List<UserInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val EVEN_VIEW_TYPE = 0 // 짝수 multi-type
        const val ODD_VIEW_TYPE = 1 // 홀수 multi-type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            EVEN_VIEW_TYPE -> {
                val binding = RecyclerviewEvenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                EvenViewHolder(binding)
            }
            ODD_VIEW_TYPE -> {
                val binding = RecyclerviewOddBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                OddViewHolder(binding)
            }
            else -> throw Exception("Type Error") // 선택된 Type이 없을때
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder.itemViewType) {
            EVEN_VIEW_TYPE -> {
                (holder as EvenViewHolder).bind(item)
            }
            ODD_VIEW_TYPE -> {
                (holder as OddViewHolder).bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0){
            EVEN_VIEW_TYPE
        } else {
            ODD_VIEW_TYPE
        }
    }

    inner class EvenViewHolder(private val binding: RecyclerviewEvenBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserInfo) {
            var isClickEvent = false

            binding.apply {
                ivImage.setImageResource(item.image)
                tvPhoneNumber.text = item.phoneNumber

                ivFavorite.setOnClickListener {
                    isClickEvent = !isClickEvent

                    if (isClickEvent){
                        ivFavorite.setImageResource(R.drawable.img_favorite)
                    } else {
                        ivFavorite.setImageResource(R.drawable.img_empty_favorite)
                    }

                }
            }
        }
    }

    inner class OddViewHolder(private val binding: RecyclerviewOddBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserInfo) {
            var isClickEvent = false
            binding.apply {
                ivImage.setImageResource(item.image)
                tvPhoneNumber.text = item.phoneNumber

                ivFavorite.setOnClickListener {
                    isClickEvent = !isClickEvent

                    if (isClickEvent){
                        ivFavorite.setImageResource(R.drawable.img_favorite)
                    } else {
                        ivFavorite.setImageResource(R.drawable.img_empty_favorite)
                    }

                }
            }
        }
    }

}