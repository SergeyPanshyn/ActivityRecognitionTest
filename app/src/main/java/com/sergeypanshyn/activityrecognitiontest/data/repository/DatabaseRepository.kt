package com.sergeypanshyn.activityrecognitiontest.data.repository

import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
interface DatabaseRepository {

    fun saveActivityPoint(activityModel: ActivityModel)

    fun getAllActivities(): Single<List<ActivityModel>>

    fun clearAllActivities(): Completable

}