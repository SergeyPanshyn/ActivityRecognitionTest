package com.sergeypanshyn.activityrecognitiontest

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.google.android.gms.location.ActivityRecognitionResult
import com.google.android.gms.location.DetectedActivity
import com.sergeypanshyn.activityrecognitiontest.data.database.entity.ActivityModel
import com.sergeypanshyn.activityrecognitiontest.data.repository.ActivityCheckManager
import javax.inject.Inject

class DetectedActivitiesIntentService : IntentService(TAG) {

    companion object {

        private const val TAG = "DetectedActivitiesIS"
    }

    @Inject
    lateinit var activityCheckManager: ActivityCheckManager

    private var currentActivityType: Int = -1

    override fun onCreate() {
        super.onCreate()

        ActivityRecognitionApp.appComponent?.inject(this)
    }

    override fun onHandleIntent(intent: Intent?) {
        val result = ActivityRecognitionResult.extractResult(intent)

        handleDetectedActivities(result.probableActivities)
    }

    private fun handleDetectedActivities(probableActivities: List<DetectedActivity>) {
        for (activity in probableActivities) {
            Log.d("logging", "Type:${activity.type}")
            Log.d("logging", "Current type:${currentActivityType}")
            if (activity.confidence > 75 && currentActivityType != activity.type) {
                activityCheckManager.detectActivityChange(ActivityModel(System.currentTimeMillis(), mapDetectedActivityType(activity), activity.confidence))

                currentActivityType = activity.type
            }
        }
    }

    private fun mapDetectedActivityType(activity: DetectedActivity): String {
        when (activity.type) {
            DetectedActivity.IN_VEHICLE -> {
                Log.e("ActivityRecogition", "In Vehicle: " + activity.confidence)
                return "In Vehicle"
            }
            DetectedActivity.ON_BICYCLE -> {
                Log.e("ActivityRecogition", "On Bicycle: " + activity.confidence)
                return "On Bicycle"
            }
            DetectedActivity.ON_FOOT -> {
                Log.e("ActivityRecogition", "On Foot: " + activity.confidence)
                return "On Foot"
            }
            DetectedActivity.RUNNING -> {
                Log.e("ActivityRecogition", "Running: " + activity.confidence)
                return "Running"
            }
            DetectedActivity.STILL -> {
                Log.e("ActivityRecogition", "Still: " + activity.confidence)
                return "Still"
            }
            DetectedActivity.TILTING -> {
                Log.e("ActivityRecogition", "Tilting: " + activity.confidence)
                return "Tilting"
            }
            DetectedActivity.WALKING -> {
                Log.e("ActivityRecogition", "Walking: " + activity.confidence)
                return "Walking"
            }
            DetectedActivity.UNKNOWN -> {
                Log.e("ActivityRecogition", "Unknown: " + activity.confidence)
                return "Unknown"
            }
        }
        return "Unknown"
    }
}
