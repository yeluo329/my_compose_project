package com.example.test_project

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import coil.target.ImageViewTarget

class CoilImageViewTarget(override val view: CoilImageView) : ImageViewTarget(view) {
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("TAG", "开始加载")
    }

    override fun onSuccess(result: Drawable) {
        super.onSuccess(result)
        Log.d("TAG", "加载成功")
    }

    override fun onError(error: Drawable?) {
        super.onError(error)
        Log.d("TAG", "$error")
    }
}