package com.bangkit.riskque.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.riskque.databinding.ItemRowDplkBinding
import com.bangkit.riskque.model.Dplk

class DplkListAdapter :
    PagingDataAdapter<Dplk, DplkListAdapter.ListViewHolder>(MyDiffUtil) {

    var onItemClick: ((Dplk) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowDplkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }

        /*
        val photo =
            ObjectAnimator.ofFloat(holder.binding.ivItemPhoto, View.ALPHA, 1f).setDuration(500)
        val name =
            ObjectAnimator.ofFloat(holder.binding.tvItemName, View.ALPHA, 1f).setDuration(500)
        val desc = ObjectAnimator.ofFloat(holder.binding.tvItemDescription, View.ALPHA, 1f)
            .setDuration(500)
        val date =
            ObjectAnimator.ofFloat(holder.binding.tvItemDate, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(photo, name, desc, date)
            start()
        }

         */
    }

    inner class ListViewHolder(val binding: ItemRowDplkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Dplk) {
            binding.apply {
                tvDplkName.text = data.name
                tv1YearReturnData.text = data.lon.toString()
                tvExpenseRatioData.text = data.lon.toString()
                tvTotalAumData.text = data.lon.toString()

                /*
                                Glide.with(itemView.context).load(data.photoUrl).into(ivItemPhoto)

                 */
            }
        }

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick?.invoke(getItem(position)!!)
                }
            }
        }
    }

    object MyDiffUtil : DiffUtil.ItemCallback<Dplk>() {
        override fun areItemsTheSame(oldItem: Dplk, newItem: Dplk): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Dplk, newItem: Dplk): Boolean {
            return oldItem.id == newItem.id
        }
    }

}