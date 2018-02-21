package com.sergeypanshyn.activityrecognitiontest.presentation.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sergeypanshyn.activityrecognitiontest.R
import com.sergeypanshyn.activityrecognitiontest.data.entity.model.ActivityModel
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class MainAdapter(val context: Context, val data: List<ActivityModel>): RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)

        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        val current = data[position]
        holder?.activityTypeTv?.text = context.getString(R.string.activity_type, current.activityType)
        holder?.percentTv?.text = context.getString(R.string.activity_confidence, current.activityConfidence)
        holder?.timeTv?.text = context.getString(R.string.activity_time, getNeededFormat(current.timestamp))
    }

    override fun getItemCount() = data.size

    private fun getNeededFormat(timestamp: Long): String {
        val sdf = SimpleDateFormat("HH:mm")
        val resultDate = Date(timestamp)
        return sdf.format(resultDate)
    }
}