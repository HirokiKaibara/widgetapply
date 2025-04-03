package com.example.widgetapply.ui.fragments.chip.wallpaper

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

class WallpaperFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallpaper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 人気の壁紙セクション（紫系の色）
        setupRecyclerView(
            R.id.popularWallpaperRecyclerView,
            Color.parseColor("#E6E6FA")
        )

        // 新着セクション（ピンク系の色）
        setupRecyclerView(
            R.id.newWallpaperRecyclerView,
            Color.parseColor("#FFB6C1")
        )

        // おしゃれセクション（青系の色）
        setupRecyclerView(
            R.id.stylishWallpaperRecyclerView,
            Color.parseColor("#ADD8E6")
        )
    }

    private fun setupRecyclerView(
        recyclerViewId: Int,
        backgroundColor: Int
    ) {
        view?.findViewById<RecyclerView>(recyclerViewId)?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = WallpaperListAdapter(backgroundColor)
        }
    }
}