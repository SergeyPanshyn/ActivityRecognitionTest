package com.sergeypanshyn.activityrecognitiontest.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.sergeypanshyn.activityrecognitiontest.data.database.dao.ActivityPointDao
import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
@Database(entities = arrayOf(ActivityModel::class), version = 1)
abstract class ActivityDatabase : RoomDatabase() {

    abstract fun getActivityPointDao(): ActivityPointDao

}