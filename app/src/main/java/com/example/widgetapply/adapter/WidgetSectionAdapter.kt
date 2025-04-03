package com.example.widgetapply.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R
import android.widget.LinearLayout

class WidgetSectionAdapter(
    private val backgroundColor: Int,
    private val isFirstItemLarge: Boolean = false,
    private val normalWidth: Int,
    private val normalHeight: Int,
    private val largeWidth: Int = 214,
    private val largeHeight: Int = 100
) : RecyclerView.Adapter<WidgetSectionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: CardView = view as CardView
        val background: View = view.findViewById(R.id.itemBackground)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget_section, parent, false)
        
        // viewTypeに基づいてサイズを設定（0が大きいカード、1が通常サイズ）
        val width = if (viewType == 0) largeWidth else normalWidth
        val height = if (viewType == 0) largeHeight else normalHeight
        
        // CardViewのLayoutParamsを直接設定
        val params = LinearLayout.LayoutParams(width, height)
        params.marginStart = 8
        params.marginEnd = 8
        view.layoutParams = params
        
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 && isFirstItemLarge) 0 else 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.background.setBackgroundColor(backgroundColor)
        
        // サイズを再設定（確実に適用されるように）
        val width = if (position == 0 && isFirstItemLarge) largeWidth else normalWidth
        val height = if (position == 0 && isFirstItemLarge) largeHeight else normalHeight
        
        val params = holder.container.layoutParams as LinearLayout.LayoutParams
        params.width = width
        params.height = height
        holder.container.layoutParams = params
    }

    override fun getItemCount() = 5
}