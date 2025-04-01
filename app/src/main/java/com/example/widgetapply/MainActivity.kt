package com.example.widgetapply

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.widgetapply.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: CategoryPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // ロゴテキストの設定
            supportActionBar?.apply {
                title = "Logo"
                setDisplayShowCustomEnabled(true)
                setCustomView(TextView(applicationContext).apply {
                    text = title
                    gravity = Gravity.CENTER
                    textSize = 20f
                })
            }

            // ViewPagerの設定
            viewPager = binding.viewPager
            pagerAdapter = CategoryPagerAdapter(this)
            viewPager.adapter = pagerAdapter

            // TabLayoutとViewPager2の連携
            TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
                tab.text = pagerAdapter.getPageTitle(position)
            }.attach()

            // BottomNavigationViewの設定
            binding.bottomNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        // ホーム画面の処理
                        true
                    }
                    R.id.navigation_search -> {
                        // 検索画面の処理
                        true
                    }
                    R.id.navigation_add -> {
                        // 追加画面の処理
                        true
                    }
                    R.id.navigation_favorite -> {
                        // お気に入り画面の処理
                        true
                    }
                    R.id.navigation_mypage -> {
                        // マイページ画面の処理
                        true
                    }
                    else -> false
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // エラーメッセージをトースト表示
            Toast.makeText(this, "エラーが発生しました: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}