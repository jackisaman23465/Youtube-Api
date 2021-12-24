package com.jagertech.youtubeapi

import android.app.Application
import timber.log.Timber

class YoutubeApiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}