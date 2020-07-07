package com.gabriel.swarmintelligence.activity_lead

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gabriel.swarmintelligence.R
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.dialog_video.view.*
import kotlinx.android.synthetic.main.dialog_warn.*

class activity_swarm_warning  : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.dialog_warn)

        tv_understand.setOnClickListener(this)
        tv_exit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_understand -> {
                val intent = Intent(this, activity_warn::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.tv_exit -> {
                val intent = Intent(this, activity_lead_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}