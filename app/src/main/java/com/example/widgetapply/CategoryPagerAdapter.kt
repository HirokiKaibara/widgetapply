package com.example.widgetapply

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.widgetapply.ui.fragments.chip.*

class CategoryPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        AllFragment(),
        TemplateFragment(),
        WidgetFragment(),
        IconFragment(),
        WallpaperFragment(),
        LockscreenFragment(),
        LiveWallpaperFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getPageTitle(position: Int): String {
        return when (position) {
            0 -> "全て"
            1 -> "テンプレート"
            2 -> "ウィジェット"
            3 -> "アイコン"
            4 -> "壁紙"
            5 -> "ロック画面"
            6 -> "ライブ壁紙"
            else -> ""
        }
    }
}