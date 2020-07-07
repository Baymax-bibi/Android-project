package com.gabriel.swarmintelligence.activity_team

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.gabriel.swarmintelligence.adapter.RankingListAdapter
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_leaderboard.*
import kotlinx.android.synthetic.main.fragment_leaderboard.fab
import kotlinx.android.synthetic.main.fragment_leaderboard.teamButton
import kotlinx.android.synthetic.main.layout_header.view.*

class activity_team_leaderboard  : AppCompatActivity() , View.OnClickListener{
    val rank = arrayOf<String>("1", "2", "3", "4", "5")
    val username = arrayOf<String>(
        "Gabriel", "Eric", "Chris", "Alek", "Ben"
    )

    val points = arrayOf<String>(
        "200", "185", "180", " 178", "162"
    )

    val rank_all = arrayOf<String>("1", "2", "3", "4", "5", "6", "7")
    val username_all = arrayOf<String>(
        "Gabriel", "Eric", "Chris", "Alek", "Ben", "Alek", "Ben"
    )

    val points_all = arrayOf<String>(
        "200", "185", "180", " 178", "162", " 178", "162"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_leaderboard)

        header.titleText.text = getString(R.string.team_leaderboard)

        val myListAdapter = RankingListAdapter(this,rank,username,points)
        lv_ranking_point.adapter = myListAdapter

        tv_yourteam.setOnClickListener{v->
            tv_yourteam.setBackgroundResource(R.drawable.button)
            tv_allteam.setBackgroundResource(R.drawable.button_outline)
            val myListAdapter = RankingListAdapter(this,rank,username,points)
            lv_ranking_point.adapter = myListAdapter
        }

        tv_allteam.setOnClickListener{v->
            tv_yourteam.setBackgroundResource(R.drawable.button_outline)
            tv_allteam.setBackgroundResource(R.drawable.button)
            val myListAdapter = RankingListAdapter(this,rank_all,username_all,points_all)
            lv_ranking_point.adapter = myListAdapter
        }

        header.setOnClickListener{v->
            val intent = Intent(this, activity_team_main::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }

        lv_ranking_point.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }

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


    override fun onClick(v: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when(v?.id) {
            R.id.btn_continue->{
//                val Fragment_play_swarm = fragment_play_swarm();
//                childFragmentManager.beginTransaction().replace(R.id.container,Fragment_play_swarm).commit()
            }
        }
    }
}