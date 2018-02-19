package com.sergeypanshyn.activityrecognitiontest

import android.app.Application
import com.sergeypanshyn.activityrecognitiontest.presentation.di.AppComponent
import com.sergeypanshyn.activityrecognitiontest.presentation.di.AppModule
import com.sergeypanshyn.activityrecognitiontest.presentation.di.DaggerAppComponent

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class ActivityRecognitionApp: Application() {

    companion object {
        var speedApp: ActivityRecognitionApp? = null

        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        speedApp = this
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent?.inject(this)

    }

}