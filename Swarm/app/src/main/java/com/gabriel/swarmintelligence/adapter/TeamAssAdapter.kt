package com.gabriel.swarmintelligence.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.swarmintelligence.Model.AssModel
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.minterface.RVOnItemClickListener
import java.util.*

class TeamAssAdapter(_mListener : RVOnItemClickListener) : RecyclerView.Adapter<TeamAssAdapter.ViewHolder>() {

    var ass_list: List<AssModel>

    private var myListener: RVOnItemClickListener

    init {
        myListener = _mListener
        ass_list = ArrayList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ass, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ass_list.size
    }

    class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var item_ass_name: TextView
        val item_ass_remove : TextView

        init {
            item_ass_name = itemView.findViewById<View>(R.id.item_ass_name) as TextView
            item_ass_remove = itemView.findViewById<View>(R.id.item_ass_remove) as TextView
        }
    }

    fun submitList(blogList: List<AssModel>){
        ass_list = blogList
    }

    fun remove(r: Int) {
        ass_list.toMutableList().apply {
            removeAt(r)
            Log.e("Item_count", ass_list.toString())
            notifyItemRemoved(r)
        }

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val assModel: AssModel = ass_list.get(position)

        val name: String = assModel.toString()
        holder.item_ass_name.setText(name)

        holder.itemView.setOnClickListener { v ->

            notifyItemChanged(position)
            myListener.RVonitemlistener(v, position)
        }
    }
}