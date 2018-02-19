package com.sergeypanshyn.activityrecognitiontest.presentation.main

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class MainPresenterImpl<T: MainPresenter.MainView>(): MainPresenter<T> {

    private var view: T? = null

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}