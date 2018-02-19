package com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers

import io.reactivex.Scheduler

interface ObserveOn {

    val scheduler: Scheduler
}
