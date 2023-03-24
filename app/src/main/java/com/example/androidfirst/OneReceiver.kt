package com.example.androidfirst

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.RemoteInput

class OneReceiver : BroadcastReceiver() {

    //broadCast 메시지 전달오면 실행하는 콜백함수
    override fun onReceive(context: Context, intent: Intent) {
        val reply_Text = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("kdj_noti_reply")
        Log.e("OneReceiver", "알림창에서 전달한 메시지 ${reply_Text}")

        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)
    }
}