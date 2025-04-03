package com.example.widgetapply.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R

class WallpaperListAdapter(
    private val backgroundColor: Int
) : RecyclerView.Adapter<WallpaperListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: CardView = view as CardView
        val preview: View = view.findViewById(R.id.wallpaperPreview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wallpaper_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.preview.setBackgroundColor(backgroundColor)
    }

    override fun getItemCount() = 4  // 各セクション4アイテムを表示
}