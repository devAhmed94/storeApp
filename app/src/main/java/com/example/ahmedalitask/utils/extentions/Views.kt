package com.example.ahmedalitask.utils.extentions

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.ahmedalitask.R


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/06/2023
 */

/**
 * Set LinearLayoutManager to RecyclerView
 * @param orientation (VERTICAL or HORIZONTAL)
 */
fun RecyclerView.linearLayoutManager(@RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL) {
    layoutManager = LinearLayoutManager(this.context, orientation, false)
}


fun ImageView.load(imageUrl: String, radius: Int = 1) {
    Glide.with(this).load(imageUrl)
        .placeholder(R.drawable.black_image)
        .error(R.drawable.black_image)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(radius))).into(this)
}

/**
 * Set view visibility visible
 */
fun View.visible() {
    visibility = View.VISIBLE
}


/**
 * Set view visibility gone
 */
fun View.gone() {
    visibility = View.GONE
}