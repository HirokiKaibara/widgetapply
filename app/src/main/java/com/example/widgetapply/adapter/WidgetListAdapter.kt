package com.example.widgetapply.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R

class WidgetListAdapter(
    private val backgroundColor: Int,
    private val firstItemWidth: Int,
    private val firstItemHeight: Int,
    private val otherItemWidth: Int,
    private val otherItemHeight: Int
) : RecyclerView.Adapter<WidgetListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: CardView = view as CardView
        val background: View = view.findViewById(R.id.itemBackground)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget_card, parent, false)

        // ポジションに応じてサイズを設定
        val width = if (viewType == 0) firstItemWidth else otherItemWidth
        val height = if (viewType == 0) firstItemHeight else otherItemHeight

        val params = ViewGroup.LayoutParams(width, height)
        view.layoutParams = params

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 && firstItemWidth != otherItemWidth) 0 else 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.background.setBackgroundColor(backgroundColor)
    }

    override fun getItemCount() = 5
}