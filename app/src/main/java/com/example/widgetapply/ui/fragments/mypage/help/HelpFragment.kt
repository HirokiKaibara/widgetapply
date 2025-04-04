package com.example.widgetapply.ui.fragments.mypage.help

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.widgetapply.MainActivity
import com.example.widgetapply.R

class HelpFragment : Fragment() {

    // アコーディオンセクションの参照
    private lateinit var sections: List<AccordionSection>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 戻るボタンの設定
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            (activity as? MainActivity)?.onBackPressed()
        }

        // アコーディオンセクションを初期化
        initAccordionSections(view)
    }

    private fun initAccordionSections(view: View) {
        // 各セクションの参照を取得
        sections = listOf(
            AccordionSection(
                view.findViewById(R.id.purchaseHeader),
                view.findViewById(R.id.purchaseContent),
                view.findViewById(R.id.purchaseExpandIcon)
            ),
            AccordionSection(
                view.findViewById(R.id.downloadHeader),
                view.findViewById(R.id.downloadContent),
                view.findViewById(R.id.downloadExpandIcon)
            ),
            AccordionSection(
                view.findViewById(R.id.helpItem1Header),
                view.findViewById(R.id.helpItem1Content),
                view.findViewById(R.id.helpItem1ExpandIcon)
            ),
            AccordionSection(
                view.findViewById(R.id.helpItem2Header),
                view.findViewById(R.id.helpItem2Content),
                view.findViewById(R.id.helpItem2ExpandIcon)
            ),
            AccordionSection(
                view.findViewById(R.id.helpItem3Header),
                view.findViewById(R.id.helpItem3Content),
                view.findViewById(R.id.helpItem3ExpandIcon)
            )
        )

        // 各セクションにクリックリスナーを設定
        sections.forEachIndexed { index, section ->
            section.headerView.setOnClickListener {
                toggleSection(index)
            }
        }
    }

    private fun toggleSection(index: Int) {
        val section = sections[index]
        
        // コンテンツの表示/非表示を切り替える
        if (section.contentView.visibility == View.VISIBLE) {
            // 非表示にする
            section.contentView.visibility = View.GONE
            // 矢印を下向きに回転
            rotateArrow(section.arrowView, 0f)
        } else {
            // 表示する
            section.contentView.visibility = View.VISIBLE
            // 矢印を上向きに回転
            rotateArrow(section.arrowView, 180f)
        }
    }

    private fun rotateArrow(arrowView: ImageView, rotation: Float) {
        // 矢印を回転させるアニメーション
        ObjectAnimator.ofFloat(arrowView, View.ROTATION, arrowView.rotation, rotation).apply {
            duration = 300
            start()
        }
    }

    // アコーディオンセクションのデータクラス
    private data class AccordionSection(
        val headerView: View,
        val contentView: TextView,
        val arrowView: ImageView
    )
}
