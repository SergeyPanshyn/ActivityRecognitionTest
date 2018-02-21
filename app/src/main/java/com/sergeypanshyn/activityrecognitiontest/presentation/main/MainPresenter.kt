package com.sergeypanshyn.activityrecognitiontest.presentation.main

import com.sergeypanshyn.activityrecognitiontest.data.entity.model.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.presentation.Presenter

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
interface MainPresenter<T>: Presenter<T> {

    interface MainView {

        fun showActivity(activityModel: ActivityModel)

    }

    fun subscribeToActivityChange()

}