package com.sergeypanshyn.activityrecognitiontest.presentation.main

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.gms.location.ActivityRecognitionClient
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.sergeypanshyn.activityrecognitiontest.ActivityRecognitionApp
import com.sergeypanshyn.activityrecognitiontest.DetectedActivitiesIntentService
import com.sergeypanshyn.activityrecognitiontest.R
import com.sergeypanshyn.activityrecognitiontest.data.entity.model.ActivityModel
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

    private val items = ArrayList<ActivityModel>()

    private var mActivityRecognitionClient: ActivityRecognitionClient? = null

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
        requestActivityUpdatesButtonHandler()
        mainPresenter.subscribeToActivityChange()
    }

    fun requestActivityUpdatesButtonHandler() {
        mActivityRecognitionClient = ActivityRecognitionClient(this)

        val task = mActivityRecognitionClient!!.requestActivityUpdates(
                5 * 1000,
                getActivityDetectionPendingIntent())

        task.addOnSuccessListener(OnSuccessListener<Void> {
            Toast.makeText(this, "Connected successfully.", Toast.LENGTH_SHORT).show()
        })

        task.addOnFailureListener(OnFailureListener {
            Toast.makeText(this, "Failed connect.", Toast.LENGTH_SHORT).show()
        })
    }

    private fun getActivityDetectionPendingIntent(): PendingIntent {
        val intent = Intent(this, DetectedActivitiesIntentService::class.java)

        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
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

    override fun showActivity(activityModel: ActivityModel) {
        items.add(activityModel)
        mainAdapter?.notifyDataSetChanged()
    }
}
