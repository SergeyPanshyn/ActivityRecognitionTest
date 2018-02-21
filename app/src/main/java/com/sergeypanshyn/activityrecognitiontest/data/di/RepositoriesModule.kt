package com.sergeypanshyn.activityrecognitiontest.data.di


import com.sergeypanshyn.activityrecognitiontest.data.repository.ActivityCheckManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideActivityCheckManager() =
            ActivityCheckManager()

}
