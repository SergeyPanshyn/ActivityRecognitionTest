package com.sergeypanshyn.activityrecognitiontest.data.entity.model

/**
 * Created by Sergey Panshyn on 21.02.2018.
 */
data class ActivityModel(
        val timestamp: Long,
        val activityType: String,
        val activityConfidence: Int
)