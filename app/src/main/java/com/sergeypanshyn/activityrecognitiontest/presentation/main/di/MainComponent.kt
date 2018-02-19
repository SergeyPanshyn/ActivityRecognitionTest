package com.sergeypanshyn.activityrecognitiontest.presentation.main.di

import com.sergeypanshyn.activityrecognitiontest.presentation.di.PerActivity
import com.sergeypanshyn.activityrecognitiontest.presentation.main.MainActivity
import dagger.Subcomponent

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
@PerActivity
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

}