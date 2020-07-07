package com.gabriel.swarmintelligence.activity_lead

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.gabriel.swarmintelligence.adapter.MyAdapter
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.fragment_swarm_review.*
import kotlinx.android.synthetic.main.item_swarm_review.view.*
import kotlinx.android.synthetic.main.recycler_view_holder.view.*
import java.util.*

class activity_swarm_review  : AppCompatActivity(), View.OnClickListener{


    private val itemTouchHelper by lazy {

        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, 0) {

            override fun onMove(recyclerView: RecyclerView,
                                viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean {
                val adapter = recyclerView.adapter as MyAdapter
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                adapter.moveItem(from, to)

                adapter.notifyItemMoved(from, to)

                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)

                if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    viewHolder?.itemView?.alpha = 0.5f
                }
            }

            override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                viewHolder?.itemView?.alpha = 1.0f
                val adapter = recyclerView.adapter as MyAdapter
                adapter.notifyDataSetChanged()
            }
        }

        ItemTouchHelper(simpleItemTouchCallback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_swarm_review)

        var content = listOf(
            "Debt Collector",
            "Synthetic Voice",
            "Bank Account Scam",
            "IRS Scam"
        ).toMutableList()
        var rank_ping = listOf(
            "1",
            "2",
            "3",
            "4"
        ).toMutableList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(this, rank_ping, content)

        itemTouchHelper.attachToRecyclerView(recyclerView)

        fab.setOnClickListener{v->
            val intent = Intent(this, activity_lead_main::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }
        teamButton.setOnClickListener{v->
            val intent = Intent(this, Create_UserName::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }
    }

    fun startDragging(viewHolder: RecyclerView.ViewHolder){
        itemTouchHelper.startDrag(viewHolder)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_continue-> {
                val intent = Intent(this, activity_counter::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}