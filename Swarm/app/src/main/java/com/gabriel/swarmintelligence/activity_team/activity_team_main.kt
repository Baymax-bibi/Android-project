package com.gabriel.swarmintelligence.activity_team

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.MainActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.gabriel.swarmintelligence.activity_team.team_association.TeamAssociation
import com.gabriel.swarmintelligence.team_favorite.TeamFavorites
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.fragment_team_main.*
import kotlinx.android.synthetic.main.fragment_team_main.fab
import kotlinx.android.synthetic.main.fragment_team_main.teamButton

class activity_team_main  : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_team_main)

        leaderboardButton.setOnClickListener(this)
        achievementsButton.setOnClickListener(this)
        discoverButton.setOnClickListener(this)
        ly_teamButton.setOnClickListener(this)
        ly_myTeam.setOnClickListener(this)
        ly_fav_edit.setOnClickListener(this)
        ly_ass_edit.setOnClickListener(this)

        fab.setOnClickListener{v->
            val intent = Intent(this, MainActivity::class.java)
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
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.leaderboardButton->{
                val intent = Intent(this, activity_team_leaderboard::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.achievementsButton->{
                val intent = Intent(this, activity_team_achievements::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.discoverButton->{
                val intent = Intent(this, activity_team_discover_people_one::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.ly_teamButton->{
                val intent = Intent(this, activity_team_create_team_interrupt::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.ly_myTeam->{
                val intent = Intent(this, activity_team_my_team::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.ly_fav_edit->{
                startActivity(Intent(this, TeamFavorites::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.ly_ass_edit->{
                startActivity(Intent(this@activity_team_main, TeamAssociation::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}