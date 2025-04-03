package com.example.widgetapply.ui.fragments.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.R

class FavoriteFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        recyclerView = view.findViewById(R.id.favoriteRecyclerView)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        // ダミーデータでアダプターを設定
        recyclerView.adapter = FavoriteAdapter()
    }

    // シンプルなアダプタークラス
    private inner class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
        // とりあえず6個のダミーアイテムを表示
        private val itemCount = 6

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_favorite, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // 後でデータバインディングを実装
        }

        override fun getItemCount() = itemCount

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    }
}