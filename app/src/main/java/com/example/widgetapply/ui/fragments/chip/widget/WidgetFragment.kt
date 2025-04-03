package com.example.widgetapply.ui.fragments.chip.widget

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R
import com.example.widgetapply.adapter.WidgetListAdapter

class WidgetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_widget, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 音楽セクション（紫系の色）- 1枚目が大きい
        setupRecyclerView(
            R.id.musicRecyclerView,
            Color.parseColor("#E6E6FA"),
            214, 100,  // 1枚目のサイズ
            102, 100   // 2枚目以降のサイズ
        )

        // 写真セクション（青系の色）- すべて同じサイズ
        setupRecyclerView(
            R.id.photoRecyclerView,
            Color.parseColor("#ADD8E6"),
            100, 100,
            100, 100
        )

        // スケジュールセクション（緑系の色）- すべて同じサイズ
        setupRecyclerView(
            R.id.scheduleRecyclerView,
            Color.parseColor("#98FB98"),
            280, 140,
            280, 140
        )

        // 占いセクション（ピンク系の色）- すべて同じサイズ
        setupRecyclerView(
            R.id.fortuneRecyclerView,
            Color.parseColor("#FFB6C1"),
            100, 100,
            100, 100
        )

        // 人気のウィジェットセクション（オレンジ系の色）- すべて同じサイズ
        setupRecyclerView(
            R.id.popularWidgetRecyclerView,
            Color.parseColor("#FFDAB9"),
            100, 100,
            100, 100
        )
    }

    private fun setupRecyclerView(
        recyclerViewId: Int,
        backgroundColor: Int,
        firstItemWidth: Int,
        firstItemHeight: Int,
        otherItemWidth: Int,
        otherItemHeight: Int
    ) {
        view?.findViewById<RecyclerView>(recyclerViewId)?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = WidgetListAdapter(
                backgroundColor,
                firstItemWidth,
                firstItemHeight,
                otherItemWidth,
                otherItemHeight
            )
        }
    }
}