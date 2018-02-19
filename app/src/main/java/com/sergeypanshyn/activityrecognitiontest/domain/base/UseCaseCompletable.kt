package com.sergeypanshyn.activityrecognitiontest.domain.base

import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.ObserveOn
import com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers.SubscribeOn
import io.reactivex.Completable

abstract class UseCaseCompletable(subscribeOn: SubscribeOn, observeOn: ObserveOn) : UseCase(subscribeOn, observeOn) {

    private var completable: Completable? = null

    fun executeCompletable(onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        if (completable == null) {
            completable = useCaseCompletable
                    .subscribeOn(subscribeOn.scheduler)
                    .observeOn(observeOn.scheduler)
                    .doOnError { completable = null }
                    .doOnComplete { completable = null }
        }
        disposables.add(completable!!.subscribe({ onComplete() },{ onError(it) }))
    }

    protected abstract val useCaseCompletable: Completable
}
