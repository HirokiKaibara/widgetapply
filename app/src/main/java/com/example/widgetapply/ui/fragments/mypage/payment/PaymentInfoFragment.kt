package com.example.widgetapply.ui.fragments.mypage.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.widgetapply.R
import com.example.widgetapply.MainActivity
import com.google.android.material.imageview.ShapeableImageView

class PaymentInfoFragment : Fragment() {

    private lateinit var backButton: ImageView
    private lateinit var profileImage: ShapeableImageView
    private lateinit var userName: TextView
    private lateinit var paymentMethodLayout: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ビューの初期化
        backButton = view.findViewById(R.id.backButton)
        profileImage = view.findViewById(R.id.profileImage)
        userName = view.findViewById(R.id.userName)
        paymentMethodLayout = view.findViewById(R.id.paymentMethodLayout)

        // 戻るボタンの設定
        backButton.setOnClickListener {
            (activity as? MainActivity)?.onBackPressed()
        }

        // 購入情報ボタンの設定
        paymentMethodLayout.setOnClickListener {
            // 将来的に実装する購入情報入力画面への遷移
            // ここにコードを追加
        }

        // ユーザー情報の設定
        // 本来はアカウント情報から取得するが、現時点ではダミーデータを使用
        userName.text = "[ましゅう] さん"
        
        // プロフィール画像の設定
        // 実際にはアカウント画面で設定した画像を使用する
        // 将来的には以下のようなコードを追加
        // profileImage.setImageBitmap(userProfileImage)
    }
}

