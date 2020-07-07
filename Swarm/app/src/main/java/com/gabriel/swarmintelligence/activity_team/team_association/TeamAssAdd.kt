package com.gabriel.swarmintelligence.activity_team.team_association

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.gabriel.swarmintelligence.team_favorite.TeamFavorites
import com.mikhaellopez.circularimageview.CircularImageView
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_ass_add.*
import kotlinx.android.synthetic.main.activity_fav_search.*
import kotlinx.android.synthetic.main.activity_fav_search.fab
import kotlinx.android.synthetic.main.activity_fav_search.header_title_fav
import kotlinx.android.synthetic.main.activity_fav_search.teamButton
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_header.view.*

class TeamAssAdd : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_ass_add)

        header_title_ass.titleText.text = getString(R.string.ADDASS)
        header_title_ass.setOnClickListener(this)


//        input_username = et_fav_search.text.toString()
//        img_search_icon.setOnClickListener(this)
//        rl_search_result.setOnClickListener(this)
        fab.setOnClickListener(this)
        teamButton.setOnClickListener(this)
        btn_continue.setOnClickListener(this)

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
        when(v?.id) {
            R.id.header_title_ass->{
                startActivity(Intent(this, TeamAssociation::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.fab->{
                startActivity(Intent(this, activity_lead_main::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.teamButton->{
                startActivity(Intent(this, activity_team_main::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.btn_continue->{
                Handler().postDelayed({
                    startActivity(Intent(this@TeamAssAdd, TeamAssociation::class.java))
                    AcTrans.Builder(this@TeamAssAdd).performNoAnimation()
                    finish()
                },1000)
            }
        }
    }
}