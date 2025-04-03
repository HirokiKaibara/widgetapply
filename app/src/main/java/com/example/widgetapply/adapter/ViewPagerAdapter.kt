package com.example.widgetapply.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.widgetapply.ui.fragments.chip.all.AllFragment
import com.example.widgetapply.ui.fragments.chip.template.TemplateFragment
import com.example.widgetapply.ui.fragments.chip.widget.WidgetFragment
import com.example.widgetapply.ui.fragments.chip.icon.IconFragment
import com.example.widgetapply.ui.fragments.chip.wallpaper.WallpaperFragment
import com.example.widgetapply.ui.fragments.chip.lockscreen.LockscreenFragment
import com.example.widgetapply.ui.fragments.chip.live_wallpaper.LiveWallpaperFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            1 -> TemplateFragment()
            2 -> WidgetFragment()
            3 -> IconFragment()
            4 -> WallpaperFragment()
            5 -> LockscreenFragment()
            6 -> LiveWallpaperFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
}