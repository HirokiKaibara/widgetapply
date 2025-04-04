package com.example.widgetapply.ui.fragments.mypage.notification

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetapply.MainActivity
import com.example.widgetapply.R

class NotificationFragment : Fragment() {

    private lateinit var backButton: ImageView
    private lateinit var openSettingsButton: AppCompatButton
    private lateinit var notificationRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ビューの初期化
        backButton = view.findViewById(R.id.backButton)
        openSettingsButton = view.findViewById(R.id.openSettingsButton)
        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView)

        // 戻るボタンの設定
        backButton.setOnClickListener {
            (activity as? MainActivity)?.onBackPressed()
        }

        // 設定を開くボタンの設定
        openSettingsButton.setOnClickListener {
            openNotificationSettings()
        }

        // RecyclerViewの設定
        setupRecyclerView()
    }

    private fun openNotificationSettings() {
        // デバイスの通知設定画面を開く
        val intent = Intent()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, requireContext().packageName)
        } else {
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", requireContext().packageName)
            intent.putExtra("app_uid", requireContext().applicationInfo.uid)
        }
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        // リサイクラービューのレイアウトマネージャーを設定
        notificationRecyclerView.layoutManager = LinearLayoutManager(context)
        
        // ここではデモデータを使用します
        // 実際のアプリでは、APIからデータを取得するなどの処理を行います
        val demoNotifications = listOf(
            NotificationData("新しいウィジェットが追加されました", "2025年3月15日 10:30"),
            NotificationData("アプリがアップデートされました", "2025年3月10日 15:45"),
            NotificationData("000のダウンロードが完了しました", "2025年3月5日 09:20")
        )
        
        // アダプターを設定
        notificationRecyclerView.adapter = NotificationAdapter(demoNotifications)
    }

    // 通知データクラス
    data class NotificationData(val text: String, val date: String)

    // 通知アダプタークラス
    private inner class NotificationAdapter(private val notifications: List<NotificationData>) :
        RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_notification, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val notification = notifications[position]
            holder.textView.text = notification.text
            holder.dateView.text = notification.date
        }

        override fun getItemCount() = notifications.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: android.widget.TextView = view.findViewById(R.id.notificationText)
            val dateView: android.widget.TextView = view.findViewById(R.id.notificationDate)
        }
    }
}
