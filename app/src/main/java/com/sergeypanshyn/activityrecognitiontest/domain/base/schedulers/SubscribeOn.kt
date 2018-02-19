package com.sergeypanshyn.activityrecognitiontest.domain.base.schedulers


import io.reactivex.Scheduler

interface SubscribeOn {

     val scheduler: Scheduler
}
