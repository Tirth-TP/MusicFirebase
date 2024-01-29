package com.example.musicfirebase.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicfirebase.databinding.ItemCategoryBinding
import com.example.musicfirebase.model.firebase.CategoryModel
import com.example.musicfirebase.view.activity.SongListActivity

/**
 * Created by Tirth Patel.
 */
class CategoryAdapter(private val categoryList: List<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(category: CategoryModel) {
            binding.txtNameCat.text = category.name
            Glide.with(binding.coverImage).load(category.coverUrl)
                .apply(RequestOptions().transform(RoundedCorners(32)))
                .into(binding.coverImage)
            Log.i("Tag", category.song.size.toString())


            //For SongListActivity
            val context = binding.root.context
            binding.root.setOnClickListener {
                SongListActivity.category = category
                context.startActivity(Intent(context,SongListActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}