package com.codingblocks.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class MyAwesomeWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.e("TAG", "onUpdate: " + appWidgetIds.length);
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            CharSequence widgetText = "" + new Random().nextInt(100);
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("NUMBER", widgetText);
            PendingIntent pi = PendingIntent.getActivity(context, 123, i, PendingIntent.FLAG_UPDATE_CURRENT);

            // Construct the RemoteViews object
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_awesome_widget);
            views.setOnClickPendingIntent(R.id.relativeLayoutWidget, pi);
            views.setTextViewText(R.id.appwidget_text, widgetText);
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        Log.e("TAG", "onEnabled: ");
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        Log.e("TAG", "onDisabled: ");
        // Enter relevant functionality for when the last widget is disabled
    }
}

