package com.example.widgetapply.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R

class ContainerAdapter(private val backgroundColor: Int) : 
    RecyclerView.Adapter<ContainerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val background: View = view.findViewById(R.id.itemBackground)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_container, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.background.setBackgroundColor(backgroundColor)
    }

    override fun getItemCount() = 5 // 各セクションに5つのアイテムを表示
}