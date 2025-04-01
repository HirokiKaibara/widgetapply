package com.example.widgetapply.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R
import com.example.widgetapply.model.WidgetItem

class WidgetAdapter(private val widgets: List<WidgetItem>) : 
    RecyclerView.Adapter<WidgetAdapter.ViewHolder>() {
    
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.widgetImage)
        val textView: TextView = view.findViewById(R.id.widgetName)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget, parent, false)
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val widget = widgets[position]
        holder.imageView.setImageResource(widget.imageResId)
        holder.textView.text = widget.name
    }
    
    override fun getItemCount() = widgets.size
}
