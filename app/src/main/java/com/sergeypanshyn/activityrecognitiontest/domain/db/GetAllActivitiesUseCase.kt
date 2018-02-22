package com.sergeypanshyn.activityrecognitiontest.domain.db

import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.data.repository.DatabaseRepository
import com.sergeypanshyn.activityrecognitiontest.domain.base.UseCaseSingle
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import io.reactivex.Single

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
class GetAllActivitiesUseCase(observeOn: ObserveOn, subscribeOn: SubscribeOn, val databaseRepository: DatabaseRepository): UseCaseSingle<List<ActivityModel>>(subscribeOn, observeOn) {
    override val useCaseSingle: Single<List<ActivityModel>>
        get() = databaseRepository.getAllActivities()
}