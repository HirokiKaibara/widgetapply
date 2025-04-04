package com.example.widgetapply.ui.fragments.mypage.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.example.widgetapply.R
import com.example.widgetapply.MainActivity
import com.example.widgetapply.ui.fragments.mypage.payment.PaymentInfoFragment
import kotlin.math.abs

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

    private lateinit var scrollView: NestedScrollView
    private lateinit var stickyTitle: TextView
    private lateinit var stickyDate: TextView
    private lateinit var sections: List<TextView>
    private lateinit var sectionDates: List<TextView>
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val position = arguments?.getInt(ARG_POSITION) ?: 0
        
        // 各タブに応じたレイアウトを返す
        return when (position) {
            0 -> inflater.inflate(R.layout.fragment_all_history_content, container, false)
            else -> inflater.inflate(R.layout.fragment_tab_content, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt(ARG_POSITION) ?: 0
        
        // 「全て」タブの場合、スクロール処理とヘッダークリックリスナーを設定
        if (position == 0) {
            // 固定ヘッダーのタイトルと日付
            stickyTitle = view.findViewById(R.id.currentSectionTitle)
            stickyDate = view.findViewById(R.id.currentSectionDate)
            
            // スクロールビュー
            scrollView = view.findViewById(R.id.contentScrollView)
            
            // セクションのタイトルと日付のリスト
            sections = listOf(
                view.findViewById(R.id.sectionAll),
                view.findViewById(R.id.sectionTemplate),
                view.findViewById(R.id.sectionWidget),
                view.findViewById(R.id.sectionIcon),
                view.findViewById(R.id.sectionWallpaper),
                view.findViewById(R.id.sectionLockscreen),
                view.findViewById(R.id.sectionLiveWallpaper)
            )
            
            sectionDates = listOf(
                view.findViewById(R.id.sectionAllDate),
                view.findViewById(R.id.sectionTemplateDate),
                view.findViewById(R.id.sectionWidgetDate),
                view.findViewById(R.id.sectionIconDate),
                view.findViewById(R.id.sectionWallpaperDate),
                view.findViewById(R.id.sectionLockscreenDate),
                view.findViewById(R.id.sectionLiveWallpaperDate)
            )
            
            // スクロールリスナーを設定
            setupScrollListener()
            
            // セクションとアイテムのクリックリスナーを設定
            setupSectionClickListeners(view)
            
            return
        }
        
        // その他のタブの内容を表示
        val contentText = view.findViewById<TextView>(R.id.contentText)
        
        val tabName = when(position) {
            1 -> "テンプレート"
            2 -> "ウィジェット"
            3 -> "アイコン"
            4 -> "壁紙"
            5 -> "ロック画面"
            6 -> "ライブ壁紙"
            else -> "不明"
        }

        contentText.text = "${tabName}の履歴のみが表示されます\n\n${tabName}タブ専用の履歴画面は\n別途実装します"
    }
    
    // スクロールリスナーを設定
    private fun setupScrollListener() {
        scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // 現在表示されているセクションを特定
            var currentSectionIndex = 0
            
            for (i in sections.indices) {
                val section = sections[i]
                // セクションの親ビューの位置がスクロール位置より上にある場合
                val sectionParent = section.parent as? View
                if (sectionParent != null && sectionParent.top <= scrollY + 5) {
                    currentSectionIndex = i
                } else {
                    break
                }
            }
            
            // 上部の固定ヘッダーにセクション名と日付を設定
            stickyTitle.text = sections[currentSectionIndex].text
            stickyDate.text = sectionDates[currentSectionIndex].text
        })
    }
    
    // セクションとアイテムのクリックリスナーを設定
    private fun setupSectionClickListeners(view: View) {
        // セクションヘッダーの親LinearLayoutにクリックリスナーを設定
        (view.findViewById<TextView>(R.id.sectionTemplate).parent as? LinearLayout)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(1)
        }
        
        (view.findViewById<TextView>(R.id.sectionWidget).parent as? LinearLayout)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(2)
        }
        
        (view.findViewById<TextView>(R.id.sectionIcon).parent as? LinearLayout)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(3)
        }
        
        (view.findViewById<TextView>(R.id.sectionWallpaper).parent as? LinearLayout)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(4)
        }
        
        (view.findViewById<TextView>(R.id.sectionLockscreen).parent as? LinearLayout)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(5)
        }
        
        (view.findViewById<TextView>(R.id.sectionLiveWallpaper).parent as? LinearLayout)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(6)
        }
        
        // アイテムのクリックリスナー
        view.findViewById<View>(R.id.templateHeader)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(1)
        }
        
        view.findViewById<View>(R.id.widgetHeader)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(2)
        }
        
        view.findViewById<View>(R.id.iconHeader)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(3)
        }
        
        view.findViewById<View>(R.id.wallpaperHeader)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(4)
        }
        
        view.findViewById<View>(R.id.lockscreenHeader)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(5)
        }
        
        view.findViewById<View>(R.id.liveWallpaperHeader)?.setOnClickListener {
            (parentFragment as? DownloadHistoryFragment)?.switchToTab(6)
        }
    }
}


