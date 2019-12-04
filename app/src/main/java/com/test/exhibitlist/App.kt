package com.test.exhibitlist

import android.app.Application
import com.test.exhibitlist.di.AppComponent
import com.test.exhibitlist.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var mAppComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent() {
        mAppComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}
