package com.gabriel.swarmintelligence.team_favorite

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.mikhaellopez.circularimageview.CircularImageView
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_fav_search.*
import kotlinx.android.synthetic.main.activity_fav_search.fab
import kotlinx.android.synthetic.main.activity_fav_search.teamButton
import kotlinx.android.synthetic.main.activity_team_my_team.*
import kotlinx.android.synthetic.main.layout_header.view.*
import java.net.URL
import java.util.*

class TeamFavSearch : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_fav_search)

        header_title_fav.titleText.text = getString(R.string.ADDFAV)
        header_title_fav.setOnClickListener(this)


//        input_username = et_fav_search.text.toString()
        img_search_icon.setOnClickListener(this)
        rl_search_result.setOnClickListener(this)
        fab.setOnClickListener(this)
        teamButton.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.header_title_fav->{
                startActivity(Intent(this, TeamFavorites::class.java))
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

            R.id.img_search_icon->{
                rl_search_result.visibility = View.VISIBLE
                user_name.text = et_fav_search.text.toString()
                var image : CircularImageView = findViewById(R.id.avatar)

                Glide.with(this).load("http://i.imgur.com/DvpvklR.png").into(image)
            }
            R.id.rl_search_result->{
                var sent_invite :TextView = findViewById(R.id.sent_invite)
                sent_invite.text = "SENT"
                Handler().postDelayed({
//                    Toast.makeText(this, "after", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, TeamFavorites::class.java))
                    AcTrans.Builder(this).performNoAnimation()
                },1000)
            }
        }
    }
}