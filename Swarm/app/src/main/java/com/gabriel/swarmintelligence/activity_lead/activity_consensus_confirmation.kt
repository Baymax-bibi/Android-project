package com.gabriel.swarmintelligence.activity_lead

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_consensus_confirm.*
import kotlinx.android.synthetic.main.fragment_consensus_confirm.fab
import kotlinx.android.synthetic.main.fragment_consensus_confirm.teamButton

class activity_consensus_confirmation  : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_consensus_confirm)

        tv_exit.setOnClickListener(this)
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
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.tv_exit->{
                val intent = Intent(this, activity_cta::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}

