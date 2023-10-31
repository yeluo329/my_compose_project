package com.example.test_project

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CoilHelper.init(this)
    }
}