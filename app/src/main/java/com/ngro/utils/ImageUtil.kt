package com.ngro.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageUtil {

    fun displayImage(url: String, imageView: ImageView) {
        Glide.with(imageView.context).load(url)
            .into(imageView)
    }
}