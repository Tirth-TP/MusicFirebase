package com.example.musicfirebase.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicfirebase.databinding.ItemSongListBinding
import com.example.musicfirebase.model.firebase.SongModel
import com.example.musicfirebase.utils.MyExoplayer
import com.example.musicfirebase.view.activity.PlayerActivity
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Created by Tirth Patel.
 */

class SongListAdapter(private val songIdList: List<String>) :
    RecyclerView.Adapter<SongListAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemSongListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(songId: String) {
            FirebaseFirestore.getInstance().collection("songs")
                .document(songId).get()
                .addOnSuccessListener {
                    val song = it.toObject(SongModel::class.java)
                    song?.apply {
                        binding.txtSongTitle.text = songTitle
                        binding.txtSubTitle.text = subTitle
                        Glide.with(binding.imgSongCover).load(coverUrl).apply(
                            RequestOptions().transform(RoundedCorners(32))
                        )
                            .into(binding.imgSongCover)
                        binding.root.setOnClickListener {
                            MyExoplayer.startPlaying(binding.root.context, song)
                            it.context.startActivity(Intent(it.context, PlayerActivity::class.java))
                        }
                    }
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemSongListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return songIdList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(songIdList[position])
    }
}