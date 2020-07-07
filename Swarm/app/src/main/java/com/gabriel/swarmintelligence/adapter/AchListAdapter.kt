package com.gabriel.swarmintelligence.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.gabriel.swarmintelligence.R

class AchListAdapter (private val context: Activity, private val ach_mark: Array<Int>, private val description: Array<String>, private val imgid: Array<String>)
    : ArrayAdapter<Int>(context, R.layout.item_achievement, ach_mark) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_achievement, null, true)


        val img_ach = rowView.findViewById(R.id.img_ach) as ImageView
        val tv_ach_name = rowView.findViewById(R.id.tv_ach_name) as TextView
        val tv_poitv_ach_pointsnts = rowView.findViewById(R.id.tv_ach_points) as TextView

        img_ach.setImageResource(ach_mark[position])
        tv_ach_name.text = description[position]
        tv_poitv_ach_pointsnts.text = imgid[position]
        return rowView
    }
}