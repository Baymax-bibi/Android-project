package com.gabriel.swarmintelligence.activity_lead

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.dialog_video.view.*
import kotlinx.android.synthetic.main.fragment_play_swarm.*


class activity_play_swarm  : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_play_swarm)

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
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.btn_continue -> {
                if (et_irs.length() > 0 && et_thory.length() > 0){
                    val intent = Intent(this, activity_counter::class.java)
                    startActivity(intent)
                    AcTrans.Builder(this).performNoAnimation()
                    finish()
                }else{
                    Log.e("input", "no fill")
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_no_input_warn, null)
                    dialogView.videoView.apply {
                        //TODO
                    }

                    val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
                    builder.setView(dialogView)

                    builder.setPositiveButton(R.string.GOBACK) { dialogInterface, i ->
                        dialogInterface.dismiss()
                    }

                    val alertDialog = builder.show()
                    alertDialog.getButton(Dialog.BUTTON_POSITIVE)
                        .setTextColor(ContextCompat.getColor(this, R.color.primary_color_500))
                }
            }
        }
    }
}
