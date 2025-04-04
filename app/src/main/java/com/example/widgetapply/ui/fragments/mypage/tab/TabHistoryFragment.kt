package com.example.widgetapply.ui.fragments.mypage.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.widgetapply.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * ViewPager2とTabLayoutを使用したタブ画面の実装
 */
class TabHistoryFragment : Fragment() {
    
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_history, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // 戻るボタンの設定
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        
        // ViewPager2の設定
        viewPager = view.findViewById(R.id.viewPager)
        
        // タブのアダプターを設定
        val adapter = TabPagerAdapter(this)
        viewPager.adapter = adapter
        
        // TabLayoutの設定
        tabLayout = view.findViewById(R.id.tabLayout)
        
        // TabLayoutとViewPager2を連携
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "全て"
                1 -> "テンプレート"
                2 -> "ウィジェット"
                3 -> "アイコン"
                4 -> "壁紙"
                5 -> "ロック画面"
                6 -> "ライブ壁紙"
                else -> "タブ"
            }
        }.attach()
    }
}
