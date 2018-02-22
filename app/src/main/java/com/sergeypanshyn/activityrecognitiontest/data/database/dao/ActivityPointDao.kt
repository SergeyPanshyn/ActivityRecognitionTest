package com.sergeypanshyn.activityrecognitiontest.data.database.dao

import android.arch.persistence.room.*
import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import io.reactivex.Single

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
@Dao
interface ActivityPointDao {

    @Query("SELECT * FROM activitymodel")
    fun getAllActivities(): Single<List<ActivityModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivityPoint(activityModel: ActivityModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateActivityPoint(activityModel: ActivityModel)

    @Delete
    fun deleteActivityPoint(activityModel: ActivityModel)

    @Query("DELETE FROM activitymodel")
    fun deleteAllActivities()

}