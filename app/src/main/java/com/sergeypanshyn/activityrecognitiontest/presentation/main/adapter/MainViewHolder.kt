package com.sergeypanshyn.activityrecognitiontest.presentation.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.sergeypanshyn.activityrecognitiontest.R

/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.activity_type_tv)
    lateinit var activityTypeTv: TextView

    @BindView(R.id.percent_tv)
    lateinit var percentTv: TextView

    @BindView(R.id.time_tv)
    lateinit var timeTv: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

}