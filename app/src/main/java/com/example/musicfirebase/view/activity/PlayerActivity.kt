package com.example.musicfirebase.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.exoplayer.ExoPlayer
import com.bumptech.glide.Glide
import com.example.musicfirebase.databinding.ActivityPlayerBinding
import com.example.musicfirebase.utils.MyExoplayer

class PlayerActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlayerBinding
    lateinit var myExoPlayer: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyExoplayer.getCurrentSong()?.apply {
            binding.txtMusicTitle.text = songTitle
            binding.txtMusicSubTitle.text = subTitle

            myExoPlayer = MyExoplayer.getInstance()!!
            binding.playerView.player = myExoPlayer
        }
    }
}