package com.test.app

import android.app.Application

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseManager.init(this)
    }


}