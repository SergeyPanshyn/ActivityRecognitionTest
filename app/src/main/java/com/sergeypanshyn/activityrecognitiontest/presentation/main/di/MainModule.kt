package com.sergeypanshyn.activityrecognitiontest.presentation.main.di

import com.sergeypanshyn.activityrecognitiontest.presentation.di.PerActivity
import com.sergeypanshyn.activityrecognitiontest.presentation.main.MainPresenter
import com.sergeypanshyn.activityrecognitiontest.presentation.main.MainPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
@Module
class MainModule {

    @Provides
    @PerActivity
    fun provideMainPresenter(): MainPresenter<MainPresenter.MainView> = MainPresenterImpl()

}