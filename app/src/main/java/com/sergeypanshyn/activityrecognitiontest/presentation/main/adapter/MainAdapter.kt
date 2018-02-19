package com.sergeypanshyn.activityrecognitiontest.presentation.main.adapter

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sergeypanshyn.activityrecognitiontest.R
/**
 * Created by Sergey Panshyn on 19.02.2018.
 */
class MainAdapter(val context: Context, val data: List<String>): RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)

        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        val current = data[position]
    }

    override fun getItemCount() = data.size
}