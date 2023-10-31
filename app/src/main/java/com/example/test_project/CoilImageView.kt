package com.example.test_project

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import coil.drawable.MovieDrawable
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.repeatCount
import java.io.File

class CoilImageView(context: Context, attrs: AttributeSet? = null) :
    AppCompatImageView(context, attrs) {
//    var placeholderImageId: Int
//    var failureImageId: Int

    var loadStatus = LOAD_STATUS_IDLE
        set(value) {
            if (field == value) return
            field = value
            when (value) {
                LOAD_STATUS_IDLE, LOAD_STATUS_SUCCESS -> {

                }
            }
        }

    init {

    }

    fun load(url: String?) {
        load(url, cachePath = null)
    }


    @JvmOverloads
    fun load(
        data: Any?,
        cachePath: File? = null,
        resize: Boolean = true,
        repeatCount: Int = MovieDrawable.REPEAT_INFINITE,
        buildAction: (ImageRequest.Builder.() -> Unit)? = null
    ) {
        fun loadInner(
            data: Any,
            resize: Boolean = true,
            repeatCount: Int,
            buildAction: (ImageRequest.Builder.() -> Unit)?
        ) {
            val builder = ImageRequest.Builder(context)
            //对数据进行处理
            if (data is String) {
                //String
                //加载file图片
                if (data.startsWith("/")) {
//                    Log.d("TAG", "是https")
                    builder.data("file://$data")
                } else {

                }
                builder.data(data)
            } else {
                builder.data(data)
            }

            builder.placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_load_fail_pic)
                .crossfade(true)
                .target(CoilImageViewTarget(this))
                //gif图重复次数
                .repeatCount(repeatCount)

            if (resize) {
                val layoutParams = layoutParams
                if (layoutParams != null) {
                    var width = layoutParams.width
                    var height = layoutParams.height
                    if (width > 0 && height > 0) {

                    }
                }
            }

            val request = builder.build()
            CoilHelper.enqueue(request)
        }

        if (data == null) {
            return
        }
        loadInner(data, resize, repeatCount, buildAction)

    }

    companion object {
        const val LOAD_STATUS_IDLE = 0
        const val LOAD_STATUS_BUSY = 1
        const val LOAD_STATUS_SUCCESS = 2
        const val LOAD_STATUS_FAILURE = 3
    }
}