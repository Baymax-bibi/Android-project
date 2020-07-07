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
import kotlinx.android.synthetic.main.fragment_create_team_discover.*
import kotlinx.android.synthetic.main.layout_header.view.*


class activity_team_create_team_discover  : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_create_team_discover)

        header.titleText.text = getString(R.string.CREATETEAM)
        header.setOnClickListener(this)

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

        btn_continue.setOnClickListener{v->
            val intent = Intent(this, activity_team_discover_people_one::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }
    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.header->{
                val intent = Intent(this, activity_team_create_team_interrupt_name_fill::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }

        }
    }
}