package com.sergeypanshyn.activityrecognitiontest.presentation.di

import android.content.Context
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    internal fun provideSubscribeOn(): SubscribeOn {
        return object : SubscribeOn {
            override val scheduler: Scheduler
                get() = Schedulers.io()
        }
    }

    @Provides
    @Singleton
    internal fun provideObserveOn(): ObserveOn {
        return object : ObserveOn {
            override val scheduler: Scheduler
                get() = AndroidSchedulers.mainThread()
        }
    }
}