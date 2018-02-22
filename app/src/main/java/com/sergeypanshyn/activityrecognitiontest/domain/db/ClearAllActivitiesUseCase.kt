package com.sergeypanshyn.activityrecognitiontest.domain.db

import com.sergeypanshyn.activityrecognitiontest.data.repository.DatabaseRepository
import com.sergeypanshyn.activityrecognitiontest.domain.base.UseCaseCompletable
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import io.reactivex.Completable

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
class ClearAllActivitiesUseCase(observeOn: ObserveOn, subscribeOn: SubscribeOn, val databaseRepository: DatabaseRepository): UseCaseCompletable(subscribeOn, observeOn) {
    override val useCaseCompletable: Completable
        get() = databaseRepository.clearAllActivities()
}