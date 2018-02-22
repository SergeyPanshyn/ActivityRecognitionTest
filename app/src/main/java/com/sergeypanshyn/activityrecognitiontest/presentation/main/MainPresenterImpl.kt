package com.sergeypanshyn.activityrecognitiontest.presentation.main

import android.util.Log
import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.domain.activity.SubscribeToActivityChangeUseCase
import com.sergeypanshyn.activityrecognitiontest.domain.db.ClearAllActivitiesUseCase
import com.sergeypanshyn.activityrecognitiontest.domain.db.GetAllActivitiesUseCase
import io.reactivex.observers.ResourceObserver

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class MainPresenterImpl<T: MainPresenter.MainView>(private val subscribeToActivityChangeUseCase: SubscribeToActivityChangeUseCase,
                                                   private val getAllActivitiesUseCase: GetAllActivitiesUseCase,
                                                   private val clearAllActivitiesUseCase: ClearAllActivitiesUseCase): MainPresenter<T> {

    private var view: T? = null

    override fun subscribeToActivityChange() {
        getAllActivitiesUseCase.unsubscribe()
        subscribeToActivityChangeUseCase.executeObservable(object : ResourceObserver<ActivityModel>(){
            override fun onComplete() {
                Log.d("onxActivityDetected()", "OnComplete()")
            }

            override fun onNext(t: ActivityModel) {
                view?.showActivity(t)
            }

            override fun onError(e: Throwable) {
                Log.d("onxActivityDetected()", "Err: $e")
            }
        })
    }

    override fun getAllActivities() {
        getAllActivitiesUseCase.executeSingle(
                { view?.showAllActivities(it) },
                { Log.d("onxGetAllActivities", "Err: $it") }
        )
    }

    override fun clearAllActivities() {
        clearAllActivitiesUseCase.executeCompletable(
                { view?.onActivitiesCleared()},
                { Log.d("onxClearAllActivities", "Err: $it") }
        )
    }

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}