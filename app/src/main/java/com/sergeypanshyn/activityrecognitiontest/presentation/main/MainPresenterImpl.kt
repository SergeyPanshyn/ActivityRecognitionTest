package com.sergeypanshyn.activityrecognitiontest.presentation.main

import android.util.Log
import com.sergeypanshyn.activityrecognitiontest.data.entity.model.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.domain.activity.SubscribeToActivityChangeUseCase
import io.reactivex.observers.ResourceObserver

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class MainPresenterImpl<T: MainPresenter.MainView>(private val subscribeToActivityChangeUseCase: SubscribeToActivityChangeUseCase): MainPresenter<T> {

    private var view: T? = null

    override fun subscribeToActivityChange() {
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

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}