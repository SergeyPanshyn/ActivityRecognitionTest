package com.sergeypanshyn.activityrecognitiontest.data.di


import com.sergeypanshyn.activityrecognitiontest.data.database.ActivityDatabase
import com.sergeypanshyn.activityrecognitiontest.data.repository.ActivityCheckManager
import com.sergeypanshyn.activityrecognitiontest.data.repository.DatabaseRepository
import com.sergeypanshyn.activityrecognitiontest.data.repository.DatabaseRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideActivityCheckManager(databaseRepository: DatabaseRepository) =
            ActivityCheckManager(databaseRepository)

    @Provides
    @Singleton
    fun provideDatabaseRepository(activityDatabase: ActivityDatabase): DatabaseRepository =
            DatabaseRepositoryImpl(activityDatabase)

}
