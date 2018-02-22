package com.sergeypanshyn.activityrecognitiontest.data.repository

import com.sergeypanshyn.activityrecognitiontest.data.database.ActivityDatabase
import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
class DatabaseRepositoryImpl(private val activityDatabase: ActivityDatabase): DatabaseRepository {
    override fun saveActivityPoint(activityModel: ActivityModel) {
        activityDatabase.getActivityPointDao().insertActivityPoint(activityModel)
    }

    override fun getAllActivities(): Single<List<ActivityModel>> {
        return activityDatabase.getActivityPointDao().getAllActivities()
    }

    override fun clearAllActivities(): Completable {
        activityDatabase.getActivityPointDao().deleteAllActivities()
        return Completable.complete()
    }
}