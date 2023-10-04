package com.example.practicetest.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("getImageFromUrl")
fun ImageView.getImageFromUrl(url : String){
    Glide.with(this).load(url).into(this)
}