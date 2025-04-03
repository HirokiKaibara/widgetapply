package com.example.widgetapply.ui.fragments.chip.lockscreen

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R
import com.example.widgetapply.adapter.WallpaperListAdapter

class LockscreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lockscreen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 人気のロック画面セクション（紫系の色）
        setupRecyclerView(
            R.id.popularLockscreenRecyclerView,
            Color.parseColor("#E6E6FA")
        )

        // 新着セクション（ピンク系の色）
        setupRecyclerView(
            R.id.newLockscreenRecyclerView,
            Color.parseColor("#FFB6C1")
        )

        // おしゃれセクション（青系の色）
        setupRecyclerView(
            R.id.stylishLockscreenRecyclerView,
            Color.parseColor("#ADD8E6")
        )
    }

    private fun setupRecyclerView(
        recyclerViewId: Int,
        backgroundColor: Int
    ) {
        view?.findViewById<RecyclerView>(recyclerViewId)?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = WallpaperListAdapter(backgroundColor)  // 壁紙と同じアダプターを使用
        }
    }
}