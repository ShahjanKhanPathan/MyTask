package com.example.practicetest.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {

    private lateinit var myMedia : MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        myMedia = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        myMedia.isLooping = true
        myMedia.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        myMedia.stop()
    }
}