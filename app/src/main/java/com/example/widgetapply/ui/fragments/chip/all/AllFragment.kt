package com.example.widgetapply.ui.fragments.chip.all

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R
import com.example.widgetapply.adapter.ContainerAdapter

class AllFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ホーム画面セクション（薄いピンク系の色）
        view.findViewById<RecyclerView>(R.id.homeScreensRecyclerView).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ContainerAdapter(Color.parseColor("#FFB6C1"))  // LightPink
        }

        // ウィジェットセクション（薄い青系の色）
        view.findViewById<RecyclerView>(R.id.widgetsRecyclerView).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ContainerAdapter(Color.parseColor("#87CEEB"), ContainerAdapter.ItemType.WIDGET)  // SkyBlue
        }

        // ロック画面セクション（薄い紫系の色）
        view.findViewById<RecyclerView>(R.id.lockScreensRecyclerView).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ContainerAdapter(Color.parseColor("#DDA0DD"))  // Plum
        }
    }
}