package com.example.widgetapply.ui.fragments.mypage.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.widgetapply.MainActivity
import com.example.widgetapply.R

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 戻るボタンの設定
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            (activity as? MainActivity)?.onBackPressed()
        }

        // お問い合わせリンクの設定
        view.findViewById<LinearLayout>(R.id.contactLinkLayout).setOnClickListener {
            // ここにお問い合わせフォームのURLを設定
            val url = "https://example.com/contact"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
