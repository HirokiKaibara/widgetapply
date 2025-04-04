package com.example.widgetapply.ui.fragments.mypage.account

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.widgetapply.R
import com.google.android.material.imageview.ShapeableImageView

class AccountFragment : Fragment() {
    
    companion object {
        private const val REQUEST_IMAGE_PICK = 1001
    }
    
    private lateinit var profileImageView: ShapeableImageView
    private lateinit var userIdText: TextView
    private lateinit var loginStatusText: TextView
    
    // ユーザーID生成用（後でDB参照に置き換え）
    private var guestId = 1
    
    // 選択された画像のURI
    private var selectedImageUri: Uri? = null
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // UI要素の取得
        profileImageView = view.findViewById(R.id.profileImage)
        userIdText = view.findViewById(R.id.userIdText)
        loginStatusText = view.findViewById(R.id.loginStatusText)
        
        // 戻るボタンの設定
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        
        // プロフィール画像編集ボタンの設定
        view.findViewById<ImageView>(R.id.editProfileButton).setOnClickListener {
            openImagePicker()
        }
        
        // 初期データを表示（後でDBから取得予定）
        displayUserData()
    }
    
    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }
    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                // 選択された画像のURIを保存
                selectedImageUri = uri
                
                // ImageViewに画像をセット
                profileImageView.setImageURI(uri)
                
                // TODO: Firebaseなどにアップロード（後で実装）
                Toast.makeText(context, "プロフィール画像を変更しました", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun displayUserData() {
        // TODO: Firebaseからユーザーデータを取得する処理
        // 現在はデモデータのみ
        
        // ログインステータス設定
        val isGuest = true  // 後でFirebaseの認証状態により判定
        
        if (isGuest) {
            // ゲストユーザーの場合
            loginStatusText.text = "ゲスト"
            
            // ゲストIDをランダムに生成（仮実装）
            // 実際の実装ではFirebaseなどのDBから未使用のIDを取得
            guestId = generateGuestId()
            userIdText.text = "guest$guestId"
        } else {
            // ログインユーザーの場合
            loginStatusText.text = "ログイン中"
            userIdText.text = "user123"  // 例：実際のユーザーID
        }
    }
    
    // 仮のゲストID生成メソッド（実際の実装ではDB参照）
    private fun generateGuestId(): Int {
        // ここでは1を返しますが、実際の実装ではFirebaseから未使用のID番号を取得
        return 1
    }
}