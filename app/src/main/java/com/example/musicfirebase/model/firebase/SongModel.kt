package com.example.musicfirebase.model.firebase

/**
 * Created by Tirth Patel.
 */
data class SongModel(
    val id: String,
    val songTitle: String,
    val subTitle: String,
    val url: String,
    val coverUrl : String
){
    constructor(): this("","","","","")
}