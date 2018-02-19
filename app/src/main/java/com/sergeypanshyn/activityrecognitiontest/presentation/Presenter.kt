package com.sergeypanshyn.activityrecognitiontest.presentation

interface Presenter<T> {

    fun setView(view: T)

    fun destroy()
}