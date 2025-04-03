package com.example.widgetapply

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.widgetapply.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.title_all)
                1 -> getString(R.string.title_template)
                2 -> getString(R.string.title_widget)
                3 -> getString(R.string.title_icon)
                4 -> getString(R.string.title_wallpaper)
                5 -> getString(R.string.title_lockscreen)
                6 -> getString(R.string.title_live_wallpaper)
                else -> null
            }
        }.attach()

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> true
                R.id.navigation_search -> true
                R.id.navigation_favorite -> true
                R.id.navigation_mypage -> true
                else -> false
            }
        }
    }
}