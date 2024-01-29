package com.example.musicfirebase.model.firebase

/**
 * Created by Tirth Patel.
 */
data class CategoryModel(
    val name: String,
    val coverUrl: String,
) {
    constructor(): this("", "")
}