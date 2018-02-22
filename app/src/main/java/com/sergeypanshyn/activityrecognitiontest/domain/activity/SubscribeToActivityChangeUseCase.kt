package com.sergeypanshyn.activityrecognitiontest.domain.activity

import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.data.repository.ActivityCheckManager
import com.sergeypanshyn.activityrecognitiontest.domain.base.UseCaseStream
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import io.reactivex.Observable

/**
 * Created by Sergey Panshyn on 21.02.2018.
 */
class SubscribeToActivityChangeUseCase(observeOn: ObserveOn, subscibeOn: SubscribeOn, val activityCheckManager: ActivityCheckManager): UseCaseStream<ActivityModel>(subscibeOn, observeOn) {
    override val useCaseObservable: Observable<ActivityModel>
        get() = activityCheckManager.subscribeToActivityUpdate()
}