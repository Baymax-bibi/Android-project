package com.gabriel.swarmintelligence.activity_team

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_create_team_interrupt.*
import kotlinx.android.synthetic.main.fragment_create_team_interrupt.fab
import kotlinx.android.synthetic.main.fragment_create_team_interrupt.header_title
import kotlinx.android.synthetic.main.fragment_create_team_interrupt.teamButton
import kotlinx.android.synthetic.main.fragment_create_team_interrupt_name_fill.*
import kotlinx.android.synthetic.main.layout_header.view.*

class activity_team_create_team_interrupt_name_fill  : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_create_team_interrupt_name_fill)

        header_title.titleText.text = getString(R.string.CREATETEAM)

        header_title.setOnClickListener(this)

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
        btn_continue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.btn_continue->{

                val intent = Intent(this, activity_team_create_team_discover::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.header_title->{
                val intent = Intent(this, activity_team_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}