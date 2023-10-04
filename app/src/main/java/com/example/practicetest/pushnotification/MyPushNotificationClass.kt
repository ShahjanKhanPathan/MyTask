package com.example.practicetest.pushnotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.practicetest.R
import com.example.practicetest.googlesignin.LoginActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyPushNotificationClass : FirebaseMessagingService() {


    val notificationId : String = "notification_id"
    override fun onMessageReceived(message: RemoteMessage) {
        if (message.notification != null){
            showNotification(message.notification!!.title,message.notification!!.body)
            Log.d("myData","Title : ${message.notification!!.title.toString()} , Body : ${message.notification!!.body.toString()}")
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("myToken",token)

            // Log and toast
        })
    }


    override fun onNewToken(token: String) {
        super.onNewToken(token)

        val myToken = FirebaseMessaging.getInstance().token

        Log.d("newToken", myToken.toString())
    }



    private fun showNotification(title: String?, body: String?) {
        val intent = Intent(this,LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)


        val notificationBuilder = NotificationCompat.Builder(this,notificationId)
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(soundUri)
            .setContentIntent(pendingIntent)


        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0,notificationBuilder.build())
    }


}