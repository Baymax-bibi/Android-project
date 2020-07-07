package com.gabriel.swarmintelligence.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.gabriel.swarmintelligence.R

class MyTeamRankingListAdapter (private val context: Activity, private val title: Array<String>, private val description: Array<String>, private val imgid: Array<String>)
    : ArrayAdapter<String>(context, R.layout.item_ranking, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_myteam_ranking, null, true)


        val tv_rank = rowView.findViewById(R.id.tv_rank) as TextView
        val tv_username = rowView.findViewById(R.id.tv_username) as TextView
        val tv_points = rowView.findViewById(R.id.tv_points) as TextView

        tv_rank.text = title[position]
        tv_username.text = description[position]
        tv_points.text = imgid[position]
        return rowView
    }
}