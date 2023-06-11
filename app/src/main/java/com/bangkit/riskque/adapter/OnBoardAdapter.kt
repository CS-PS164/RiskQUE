package com.bangkit.riskque.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.riskque.R
import com.bangkit.riskque.model.OnBoardItem

class OnBoardAdapter(private val onBoardItems: List<OnBoardItem>) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardingItemViewHolder>() {

    inner class OnBoardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val image = view.findViewById<ImageView>(R.id.iv_on_board_image)
        private val description = view.findViewById<TextView>(R.id.tv_on_board_description)

        fun bind(onBoardItem: OnBoardItem) {
            image.setImageResource(onBoardItem.image)
            description.text = onBoardItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingItemViewHolder {
        return OnBoardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.on_board_item, parent, false
            )
        )
    }

    override fun getItemCount() = onBoardItems.size

    override fun onBindViewHolder(holder: OnBoardingItemViewHolder, position: Int) {
        holder.bind(onBoardItems[position])
    }
}