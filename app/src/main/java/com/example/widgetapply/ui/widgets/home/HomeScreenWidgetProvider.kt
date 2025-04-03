package com.example.widgetapply.ui.widgets.home

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.example.widgetapply.R

class HomeScreenWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        appWidgetIds.forEach { appWidgetId ->
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.widget_home_preview)
        
        // サンプルデータをセット
        views.setImageViewResource(R.id.widgetHomeImage, R.drawable.ic_home)
        views.setTextViewText(R.id.widgetHomeTitle, "カスタムホーム画面")
        views.setTextViewText(R.id.widgetHomeDescription, "タップしてカスタマイズ")

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}