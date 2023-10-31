package com.example.test_project

import android.app.Application
import android.graphics.Bitmap
import android.os.Build
import coil.Coil
import coil.ComponentRegistry
import coil.ImageLoader
import coil.decode.Decoder
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.request.ImageRequest

object CoilHelper {
    private lateinit var mImageLoader: ImageLoader

    //coil进行加载
    fun init(application: Application) {
        val applicationContext = application.applicationContext

        mImageLoader = ImageLoader.Builder(applicationContext)
            .bitmapConfig(Bitmap.Config.ARGB_8888)
            .components {
                //支持gif图
                add(GifDecoder.Factory(false))
                //支持svg
                add(SvgDecoder.Factory())
            }
            .build()
        Coil.setImageLoader(mImageLoader)
    }

    fun enqueue(request: ImageRequest) {
        if (!::mImageLoader.isInitialized) return
        mImageLoader.enqueue(request)
    }


}