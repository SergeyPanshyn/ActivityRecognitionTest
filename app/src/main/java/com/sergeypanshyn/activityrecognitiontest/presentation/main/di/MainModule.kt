package com.sergeypanshyn.activityrecognitiontest.presentation.main.di

import com.sergeypanshyn.activityrecognitiontest.data.repository.ActivityCheckManager
import com.sergeypanshyn.activityrecognitiontest.data.repository.DatabaseRepository
import com.sergeypanshyn.activityrecognitiontest.domain.activity.SubscribeToActivityChangeUseCase
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import com.sergeypanshyn.activityrecognitiontest.domain.db.ClearAllActivitiesUseCase
import com.sergeypanshyn.activityrecognitiontest.domain.db.GetAllActivitiesUseCase
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
    fun provideMainPresenter(subscribeToActivityChangeUseCase: SubscribeToActivityChangeUseCase,
                             getAllActivitiesUseCase: GetAllActivitiesUseCase,
                             clearAllActivitiesUseCase: ClearAllActivitiesUseCase): MainPresenter<MainPresenter.MainView>
            = MainPresenterImpl(subscribeToActivityChangeUseCase, getAllActivitiesUseCase, clearAllActivitiesUseCase)

    @Provides
    @PerActivity
    fun provideSubscribeToActivityChangeUseCase(observeOn: ObserveOn, subscribeOn: SubscribeOn, activityCheckManager: ActivityCheckManager)
            = SubscribeToActivityChangeUseCase(observeOn, subscribeOn, activityCheckManager)

    @Provides
    @PerActivity
    fun provideClearAllActivitiesUseCase(observeOn: ObserveOn, subscribeOn: SubscribeOn, databaseRepository: DatabaseRepository)
            = ClearAllActivitiesUseCase(observeOn, subscribeOn, databaseRepository)

    @Provides
    @PerActivity
    fun provideGetAllActivitiesUseCase(observeOn: ObserveOn, subscribeOn: SubscribeOn, databaseRepository: DatabaseRepository)
            = GetAllActivitiesUseCase(observeOn, subscribeOn, databaseRepository)
}