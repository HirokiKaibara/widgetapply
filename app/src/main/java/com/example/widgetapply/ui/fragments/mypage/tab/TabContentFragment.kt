package com.example.widgetapply.ui.fragments.mypage.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.widgetapply.R

/**
 * 各タブのコンテンツを表示するフラグメント
 */
class TabContentFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "position"

        fun newInstance(position: Int): TabContentFragment {
            val fragment = TabContentFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt(ARG_POSITION) ?: 0
        val contentText = view.findViewById<TextView>(R.id.contentText)

        val tabName = when(position) {
            0 -> "全て"
            1 -> "テンプレート"
            2 -> "ウィジェット"
            3 -> "アイコン"
            4 -> "壁紙"
            5 -> "ロック画面"
            6 -> "ライブ壁紙"
            else -> "不明"
        }

        contentText.text = "${tabName}のコンテンツがここに表示されます"
    }
}
