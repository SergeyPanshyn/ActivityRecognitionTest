package com.sergeypanshyn.activityrecognitiontest.data.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Sergey Panshyn on 22.02.2018.
 */
@Entity
data class ActivityModel(
        @PrimaryKey val timestamp: Long,
        val activityType: String,
        val activityConfidence: Int
)