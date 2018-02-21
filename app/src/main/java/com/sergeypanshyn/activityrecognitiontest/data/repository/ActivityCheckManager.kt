package com.sergeypanshyn.activityrecognitiontest.data.repository

import com.sergeypanshyn.activityrecognitiontest.data.entity.model.ActivityModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class ActivityCheckManager {

    private val activitySubject: PublishSubject<ActivityModel> = PublishSubject.create()

    fun subscribeToActivityUpdate(): Observable<ActivityModel> {
        return activitySubject
    }

    fun detectActivityChange(activityModel: ActivityModel) {
        activitySubject.onNext(activityModel)
    }

}