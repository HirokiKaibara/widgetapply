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

        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels
        val standardSize = (screenWidth - dpToPx(48)) / 4 // 基本サイズ（画面幅の1/4）

        // 音楽セクション
        setupRecyclerView(
            R.id.musicRecyclerView,
            Color.parseColor("#FFE4E1"), // ミスティローズ
            (screenWidth * 2/3), // 最初のカードは画面幅の2/3
            standardSize,    //
            standardSize,        // 他のカードは標準サイズ
            standardSize
        )

        // 写真セクション
        setupRecyclerView(
            R.id.photoRecyclerView,
            Color.parseColor("#E6E6FA"), // ラベンダー
            standardSize,
            standardSize,
            standardSize,
            standardSize
        )

        // スケジュールセクション
        setupRecyclerView(
            R.id.scheduleRecyclerView,
            Color.parseColor("#E0FFFF"), // ライトシアン
            standardSize * 2,    // 横長（標準の2倍）
            (standardSize * 1.2).toInt(), // 高さは1.2倍
            standardSize * 2,
            (standardSize * 1.2).toInt()
        )

        // 占いセクション
        setupRecyclerView(
            R.id.fortuneRecyclerView,
            Color.parseColor("#FFF0F5"), // ラベンダーブラッシュ
            standardSize,
            standardSize,
            standardSize,
            standardSize
        )

        // 人気のウィジェットセクション
        setupRecyclerView(
            R.id.popularWidgetRecyclerView,
            Color.parseColor("#F0F8FF"), // アリスブルー
            standardSize,
            standardSize,
            standardSize,
            standardSize
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

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }
}