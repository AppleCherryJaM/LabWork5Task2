package com.example.labwork4.generator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.labwork4.R
import com.example.labwork4.component.ItemOfRecyclerView
import com.example.labwork4.databinding.TouchableElementBinding

class RandomElementsAdapter(private val callback: (ItemOfRecyclerView) -> Unit)
    : ListAdapter<ItemOfRecyclerView, MainVH>(CustomCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.touchable_element,
                parent,
                false
            )
        return MainVH(view, callback)
    }

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind(getItem(position))
    }
}

class MainVH(itemView: View, private val callback: (ItemOfRecyclerView) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = TouchableElementBinding.bind(itemView)

    fun bind(item: ItemOfRecyclerView) {
        binding.apply {
            actionBtn.text = item.numericValue.toString()
            actionBtn.setBackgroundColor(item.color)
            actionBtn.setOnClickListener {
                callback(item)
            }
        }
    }
}

class CustomCallback : DiffUtil.ItemCallback<ItemOfRecyclerView>() {
    override fun areItemsTheSame(oldItem: ItemOfRecyclerView, newItem: ItemOfRecyclerView): Boolean {
        return oldItem.numericValue == newItem.numericValue
    }

    override fun areContentsTheSame(oldItem: ItemOfRecyclerView, newItem: ItemOfRecyclerView): Boolean {
        return oldItem.numericValue == newItem.numericValue
    }
}