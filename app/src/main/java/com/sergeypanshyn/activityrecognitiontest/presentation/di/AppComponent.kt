package com.sergeypanshyn.activityrecognitiontest.presentation.di

import com.sergeypanshyn.activityrecognitiontest.ActivityRecognitionApp
import com.sergeypanshyn.activityrecognitiontest.data.di.DataModule
import com.sergeypanshyn.activityrecognitiontest.presentation.main.di.MainComponent
import com.sergeypanshyn.activityrecognitiontest.presentation.main.di.MainModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, DataModule::class))
@Singleton
interface AppComponent {

    fun provideMainComponent(mainModule: MainModule): MainComponent

    fun inject(activityRecognitionApp: ActivityRecognitionApp )

}