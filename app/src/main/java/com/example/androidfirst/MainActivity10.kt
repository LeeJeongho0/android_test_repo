package com.example.androidfirst

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.example.androidfirst.databinding.ActivityMain11Binding

class MainActivity10 : AppCompatActivity() {
    lateinit var binding: ActivityMain11Binding
    lateinit var manager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNotificate.setOnClickListener {
            // 1. notificationManager 객체참조변수
            // 1. notificationCompat.Builder 객체참조변수
            manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            // 2. channel 객체참조변수를 만든다. (API 26버전이상부터 채널을 만들어줘야됨)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                // 3. 26버전 이상 채널객체참조변수
                val channelID:String = "kdj-channel"
                val channelName = "My KDJ Channel"
                val channel = NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH)

                // 채널에 대한 정보등록
                channel.description = "My KDJ Channel Describtion"
                channel.setShowBadge(true)
                // 알림음 오디오 설정
                val notificationUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributesBuilder = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
                channel.setSound(notificationUri,audioAttributesBuilder)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100,200,100,200)


                // 4. 채널을 등록 notificationManager 등록
                manager.createNotificationChannel(channel)


                // 5. 채널아이디를 이용해서 빌더생성
                builder = NotificationCompat.Builder(this,channelID)
            }else{
                // 5. 채널아이디를 이용하지않고 빌더생성
                builder = NotificationCompat.Builder(this)
            }
            // 6. builder 알림창이 어떤방법으로 구현할지 보여주는 것
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("My First Notification")
            builder.setContentText("My First Notification content")
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.nature01))

            // 7. 알림이 발생 후 터치 시 내가 지정한 엑티비티로 화면 전환하는 pendingIntent 기능부여하기
            // 7. 알림이 발생 후 터치 시 내가 broadCast 화면으로 정보를 알려준다.
            //val intent = Intent(this, DetailActivity::class.java)
            //val pendingIntent = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_IMMUTABLE)
            //builder.setContentIntent(pendingIntent)

            // 8. 알림에 액션등록하기
            /*val actionIntent = Intent(this, OneReceiver::class.java)
            val actionPendingIntent = PendingIntent.getBroadcast(this, 20,actionIntent,PendingIntent.FLAG_IMMUTABLE)

            builder.addAction(NotificationCompat.Action.Builder(
                android.R.drawable.stat_notify_more,
                "Action",
                actionPendingIntent
            ).build())*/
            // 9. 알림창에서 데이터를 입력하면 해당되는 데이터를 broadCast로 받아옴.
            // 9-1. 알림창에서 입력할 수 있는 기능부여
            val remoteInput = RemoteInput.Builder("kdj_noti_reply").run {
                setLabel("답장을 입력하세요")
                build()
            }
            val actionIntent = Intent(this, OneReceiver::class.java)
            val actionPendingIntent = PendingIntent.getBroadcast(this, 30,actionIntent,PendingIntent.FLAG_MUTABLE)
            builder.addAction(NotificationCompat.Action.Builder(
                R.drawable.baseline_schedule_send_24,
                "답장",
                actionPendingIntent
            ).addRemoteInput(remoteInput).build())
            // 10. manager 알림발생
            manager.notify(11, builder.build())
        }
        binding.btnNotificateCancel.setOnClickListener {
            manager.cancel(11)
        }
    }
}