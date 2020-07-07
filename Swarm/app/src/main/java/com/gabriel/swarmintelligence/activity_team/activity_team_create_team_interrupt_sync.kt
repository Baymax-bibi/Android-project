package com.gabriel.swarmintelligence.activity_team

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.fragment_create_team_interrupt_sync.*

class activity_team_create_team_interrupt_sync : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_create_team_interrupt_sync)

        tv_cancel.setOnClickListener(this)
        tv_allow.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.tv_cancel->{
                val intent = Intent(this, activity_team_create_team_interrupt::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.tv_allow->{
                val intent = Intent(this, activity_team_create_team_interrupt_name_fill::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}