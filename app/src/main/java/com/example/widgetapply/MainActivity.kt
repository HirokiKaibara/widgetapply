package com.example.widgetapply

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.widgetapply.adapter.ViewPagerAdapter
import com.example.widgetapply.ui.fragments.mypage.MypageFragment
import com.example.widgetapply.ui.fragments.search.SearchFragment
import com.example.widgetapply.ui.fragments.favorite.FavoriteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        setupViewPager()

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    clearMainContainer()
                    showMainContent()
                    true
                }
                R.id.navigation_search -> {
                    hideMainContent()
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.navigation_favorite -> {
                    hideMainContent()
                    replaceFragment(FavoriteFragment())
                    true
                }
                R.id.navigation_mypage -> {
                    hideMainContent()
                    replaceFragment(MypageFragment())
                    true
                }
                else -> false
            }
        }

        // 初期表示
        showMainContent()
    }

    private fun setupViewPager() {
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
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack(null)  // バックスタックに追加
            .commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()
    }

    private fun clearMainContainer() {
        supportFragmentManager.findFragmentById(R.id.mainContainer)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commitAllowingStateLoss()
            supportFragmentManager.executePendingTransactions()
        }
    }

    private fun showMainContent() {
        findViewById<TabLayout>(R.id.tabLayout).visibility = android.view.View.VISIBLE
        findViewById<ViewPager2>(R.id.viewPager).visibility = android.view.View.VISIBLE
        findViewById<android.widget.TextView>(R.id.logoText).visibility = android.view.View.VISIBLE
    }

    private fun hideMainContent() {
        findViewById<TabLayout>(R.id.tabLayout).visibility = android.view.View.GONE
        findViewById<ViewPager2>(R.id.viewPager).visibility = android.view.View.GONE
        findViewById<android.widget.TextView>(R.id.logoText).visibility = android.view.View.GONE
    }
}