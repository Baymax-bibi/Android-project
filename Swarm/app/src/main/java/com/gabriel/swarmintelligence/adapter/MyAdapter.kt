package com.gabriel.swarmintelligence.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.swarmintelligence.MainActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_consensus_confirmation
import com.gabriel.swarmintelligence.activity_lead.activity_cta
import com.gabriel.swarmintelligence.activity_lead.activity_swarm_review
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.item_swarm_review.view.*

class MyAdapter (private val activity: activity_swarm_review, private val rank_data: MutableList<String>, private val content: MutableList<String>)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_swarm_review, parent, false)
        val viewHolder = ViewHolder(itemView)

        viewHolder.itemView.ly_right4.setOnTouchListener{view, event->
            if (event.actionMasked == MotionEvent.ACTION_DOWN){
                activity.startDragging(viewHolder)
            }
            return@setOnTouchListener true
        }
        return viewHolder;
    }

    override fun getItemCount(): Int {
        return content.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ranking?.text = rank_data[position]
        holder.content?.text = content[position]
        holder.rl_container.setOnClickListener{v ->
            val intent = Intent(activity, activity_consensus_confirmation::class.java)
            activity.startActivity(intent)
            AcTrans.Builder(activity).performNoAnimation()
            activity.finish()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ranking = itemView.findViewById<TextView>(R.id.positionText)
        val content = itemView.findViewById<TextView>(R.id.titleText)
        val rl_container = itemView.findViewById<RelativeLayout>(R.id.rl_container)
    }

    fun moveItem(from: Int, to: Int) {
        val fromEmoji = content[from]

        content.removeAt(from)

        if (to < from) {
            content.add(to, fromEmoji)
            Log.e("TAG", "s")

        } else {
            content.add(to , fromEmoji)
            Log.e("TAG", "b")
        }
        Log.e("TAG", content.toString())
    }
}

