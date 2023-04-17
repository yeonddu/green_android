package com.example.ch10_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.example.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.notificationButton.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //26버전 이상
                val channelId = "one-channel"
                val channelName = "My channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    //채널에 대한 다양한 정보 설정
                    description = "My Channel One EventLogTags.Description"
                    setShowBadge(true)
                    val uri: Uri = RingtoneManager
                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                }
                    manager.createNotificationChannel(channel)
                    //채널을 이용하여 builder 생성
                    builder = NotificationCompat.Builder(this, channelId)
                } else {
                    builder = NotificationCompat.Builder(this)
                }
                builder.run {
                    //알림의 기본 정보
                    setSmallIcon(R.drawable.small)
                    setWhen(System.currentTimeMillis())
                    setContentTitle("뚱이")
                    setContentText("I LOVE YOU")
                    setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ddung))
                }
                val KEY_TEXT_REPLY = "key_text_reply"
                var replyLabel: String = "답장"
                var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
                    setLabel(replyLabel)
                    build()
                }
                val replyIntent = Intent(this, ReplyReceiver::class.java)
                val replyPendingIntent = PendingIntent.getBroadcast(this, 30, replyIntent, PendingIntent.FLAG_MUTABLE)
                builder.addAction(
                    NotificationCompat.Action.Builder(
                        R.drawable.send,
                        "답장",
                        replyPendingIntent
                    ).addRemoteInput(remoteInput).build()
                )
                manager.notify(11,builder.build())
            }
        }
    }