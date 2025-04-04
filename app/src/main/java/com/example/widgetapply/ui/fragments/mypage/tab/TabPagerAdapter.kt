package com.example.widgetapply.ui.fragments.mypage.tab

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * ViewPager2用のアダプター
 * 各タブに対応するフラグメントを提供する
 */
class TabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // タブの数
    override fun getItemCount(): Int = 7

    // 各ポジションに対応するフラグメントを生成
    override fun createFragment(position: Int): Fragment {
        // タブの位置に応じてフラグメントを生成して返す
        return TabContentFragment.newInstance(position)
    }
}
