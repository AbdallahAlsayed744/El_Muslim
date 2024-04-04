package com.example.elmuslim

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class AudioPlayer(context: Context,server:String?) {
    private var mediaPlayer: MediaPlayer? = null

    init {
        try {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(server)
                prepareAsync()
                Log.d("AudioPlayer", "success")
            }
        } catch (e: Exception) {
            Log.e("AudioPlayer", "Error setting data source", e)
        }
    }

    fun start() {
        mediaPlayer?.start()
    }

    fun stop() {
        mediaPlayer?.stop()
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

}
