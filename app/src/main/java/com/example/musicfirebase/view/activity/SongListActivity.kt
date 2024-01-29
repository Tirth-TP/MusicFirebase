package com.example.musicfirebase.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicfirebase.adapter.SongListAdapter
import com.example.musicfirebase.databinding.ActivitySongListBinding
import com.example.musicfirebase.model.firebase.CategoryModel

class SongListActivity : AppCompatActivity() {

    companion object {
        lateinit var category: CategoryModel
    }

    lateinit var binding: ActivitySongListBinding
    lateinit var songListAdapter: SongListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtMusicTitle.text = category.name

        Glide.with(binding.imgSongCoverImage).load(category.coverUrl)
            .apply(RequestOptions().transform(RoundedCorners(32)))
            .into(binding.imgSongCoverImage)

        songListRecyclerViewSetUp()
    }

    fun songListRecyclerViewSetUp() {
        songListAdapter = SongListAdapter(category.song)
        binding.rvSongList.layoutManager = LinearLayoutManager(this)
        binding.rvSongList.adapter = songListAdapter
    }
}