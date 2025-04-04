package com.example.widgetapply.ui.fragments.mypage.fanlink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.widgetapply.R

class FanlinkFragment : Fragment() {
    
    // 現在表示中のToastを保持する変数
    private var currentToast: Toast? = null
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fanlink, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // 戻るボタンの設定
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        
        // 各連携ボタンにリスナーを設定
        view.findViewById<Button>(R.id.fanlinkConnectButton).setOnClickListener {
            showToast("Fanlink連携は準備中です")
        }
        
        view.findViewById<Button>(R.id.twitterConnectButton).setOnClickListener {
            showToast("X（旧Twitter）連携は準備中です")
        }
        
        view.findViewById<Button>(R.id.googleConnectButton).setOnClickListener {
            showToast("Google連携は準備中です")
        }
        
        view.findViewById<Button>(R.id.spotifyConnectButton).setOnClickListener {
            showToast("Spotify連携は準備中です")
        }
    }
    
    // カスタムToast表示メソッド
    private fun showToast(message: String) {
        // 現在表示中のToastがあればキャンセル
        currentToast?.cancel()
        
        // 新しいToastを作成して表示（LENGTH_SHORTの半分の時間 = 約750ms）
        currentToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        currentToast?.duration = 750
        currentToast?.show()
    }
}