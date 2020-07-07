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
import com.gabriel.swarmintelligence.adapter.MyTeamEditAdapter
import com.gabriel.swarmintelligence.adapter.MyTeamRankingListAdapter
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_team_my_editteam.*
import kotlinx.android.synthetic.main.activity_team_my_team.*
import kotlinx.android.synthetic.main.activity_team_my_team.fab
import kotlinx.android.synthetic.main.activity_team_my_team.header
import kotlinx.android.synthetic.main.activity_team_my_team.lv_ranking_point
import kotlinx.android.synthetic.main.activity_team_my_team.teamButton
import kotlinx.android.synthetic.main.layout_header.view.*

class activity_team_my_team_edit : AppCompatActivity() , View.OnClickListener{

    val username = arrayOf<String>(
        "Gabriel", "Eric", "Chris", "Alek", "Ben"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_team_my_editteam)
        header.titleText.text = getString(R.string.MYTEAM)
        header.setOnClickListener(this)

        val myListAdapter = MyTeamEditAdapter(this,username)
        lv_user_edit.adapter = myListAdapter

        lv_user_edit.setOnItemClickListener(){adapterView, view, position, id ->
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
        tv_doneTeam.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.header->{
                val intent = Intent(this, activity_team_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.tv_doneTeam->{
                val intent = Intent(this, activity_team_my_team::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
//            R.id.discoverButton->{
//                val intent = Intent(this, activity_team_discover_people_one::class.java)
//                startActivity(intent)
//                finish()
//            }
//            R.id.teamButton->{
//                val intent = Intent(this, activity_team_create_team_interrupt::class.java)
//                startActivity(intent)
//                finish()
//
//            }
        }
    }
}