package com.sergeypanshyn.activityrecognitiontest.domain.base

import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import io.reactivex.disposables.CompositeDisposable

open class UseCase(protected var subscribeOn: SubscribeOn, protected var observeOn: ObserveOn) {

    protected var disposables = CompositeDisposable()

    fun unsubscribe() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}
