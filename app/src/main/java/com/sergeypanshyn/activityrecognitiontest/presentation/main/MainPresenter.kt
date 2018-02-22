package com.sergeypanshyn.activityrecognitiontest.presentation.main

import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.presentation.Presenter

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
interface MainPresenter<T>: Presenter<T> {

    interface MainView {

        fun showActivity(activityModel: ActivityModel)

        fun showAllActivities(activities: List<ActivityModel>)

        fun onActivitiesCleared()

    }

    fun subscribeToActivityChange()

    fun getAllActivities()

    fun clearAllActivities()

}