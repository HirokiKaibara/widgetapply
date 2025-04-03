package com.example.widgetapply.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R

class ContainerAdapter(
    private val backgroundColor: Int,
    private val type: ItemType = ItemType.NORMAL
) : RecyclerView.Adapter<ContainerAdapter.ViewHolder>() {

    enum class ItemType {
        NORMAL,
        WIDGET
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val background: View = view.findViewById(R.id.itemBackground)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutId = when {
            type == ItemType.WIDGET && viewType == 0 -> R.layout.item_widget_large_container
            type == ItemType.WIDGET -> R.layout.item_widget_small_container
            else -> R.layout.item_container
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (type == ItemType.WIDGET) {
            if (position == 0) 0 else 1
        } else {
            super.getItemViewType(position)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.background.setBackgroundColor(backgroundColor)
    }

    override fun getItemCount() = 5  // すべてのセクションで5つのアイテムを表示
}