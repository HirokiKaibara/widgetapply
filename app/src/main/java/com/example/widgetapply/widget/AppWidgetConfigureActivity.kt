package com.example.widgetapply.widget

import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.widgetapply.R

class AppWidgetConfigureActivity : AppCompatActivity() {
    
    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_widget_configure)
        
        // ウィジェットIDを取得
        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }
        
        // ウィジェットIDが無効な場合はアクティビティを終了
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }
        
        // 設定完了ボタン
        findViewById<Button>(R.id.buttonConfirm).setOnClickListener {
            val appWidgetManager = AppWidgetManager.getInstance(this)
            
            // ウィジェットを更新
            val appWidget = AppWidget()
            appWidget.onUpdate(this, appWidgetManager, intArrayOf(appWidgetId))
            
            // 結果を設定して終了
            val resultValue = Intent()
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            setResult(RESULT_OK, resultValue)
            finish()
        }
    }
}
