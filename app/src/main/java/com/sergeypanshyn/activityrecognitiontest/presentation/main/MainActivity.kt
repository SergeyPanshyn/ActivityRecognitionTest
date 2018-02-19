package com.sergeypanshyn.activityrecognitiontest.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.sergeypanshyn.activityrecognitiontest.ActivityRecognitionApp
import com.sergeypanshyn.activityrecognitiontest.R
import com.sergeypanshyn.activityrecognitiontest.presentation.main.adapter.MainAdapter
import com.sergeypanshyn.activityrecognitiontest.presentation.main.di.MainModule
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainPresenter.MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter<MainPresenter.MainView>

    private val mainComponent by lazy { ActivityRecognitionApp.appComponent?.provideMainComponent(MainModule()) }

    @BindView(R.id.main_layout_rv)
    lateinit var mainLayoutRv: RecyclerView

    private var mainAdapter: MainAdapter? = null

    private val items = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        daggerInit()

        initRecyclerView()
    }

    private fun daggerInit() {
        mainComponent?.inject(this)
        mainPresenter.setView(this)

    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainLayoutRv.layoutManager = layoutManager

        mainAdapter = MainAdapter(this, items)
        mainLayoutRv.adapter = mainAdapter

        val dividerItemDecoration = DividerItemDecoration(mainLayoutRv.context,
                layoutManager.getOrientation())
        mainLayoutRv.addItemDecoration(dividerItemDecoration)
    }
}
