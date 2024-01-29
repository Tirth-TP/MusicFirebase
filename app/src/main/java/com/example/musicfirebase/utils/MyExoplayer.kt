package com.example.musicfirebase.utils

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.musicfirebase.model.firebase.SongModel

/**
 * Created by Tirth Patel.
 */
object MyExoplayer {
    private var exoplayer: ExoPlayer? = null
    private var currentSong: SongModel? = null

    fun getInstance(): ExoPlayer? {
        return exoplayer
    }

    fun startPlaying(context: Context, song: SongModel) {
        if (exoplayer == null) exoplayer = ExoPlayer.Builder(context).build()

        currentSong = song
        currentSong?.url?.apply {
            val mediaItem = MediaItem.fromUri(this)
            exoplayer?.setMediaItem(mediaItem)
            exoplayer?.prepare()
            exoplayer?.play()
        }
    }
}