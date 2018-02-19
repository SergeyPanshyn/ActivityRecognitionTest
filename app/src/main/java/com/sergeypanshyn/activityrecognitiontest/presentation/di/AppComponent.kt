package com.sergeypanshyn.activityrecognitiontest.presentation.di

import com.sergeypanshyn.activityrecognitiontest.ActivityRecognitionApp
import com.sergeypanshyn.activityrecognitiontest.data.di.DataModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, DataModule::class))
@Singleton
interface AppComponent {

    fun inject(activityRecognitionApp: ActivityRecognitionApp )

}