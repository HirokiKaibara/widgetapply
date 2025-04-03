package com.example.widgetapply.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.widgetapply.ui.fragments.chip.*

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            1 -> WidgetFragment()
            2 -> WallpaperFragment()
            3 -> IconFragment()
            4 -> LiveWallpaperFragment()
            5 -> LockscreenFragment()
            6 -> TemplateFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
}