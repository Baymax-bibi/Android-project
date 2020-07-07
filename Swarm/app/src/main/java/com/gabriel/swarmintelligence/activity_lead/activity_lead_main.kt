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
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.dialog_video.view.*
import kotlinx.android.synthetic.main.dialog_warn.view.*
import kotlinx.android.synthetic.main.fragment_main.*


class activity_lead_main  : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_main)

        howToPlayButton.setOnClickListener(this)
        joinSwarmButton.setOnClickListener(this)
        joinSwarmButton.setOnClickListener(this)
        joinSwarmButton.setOnClickListener(this)

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
        when(v?.id){
            R.id.howToPlayButton->{
                val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_video, null)
                dialogView.videoView.apply {
                    //TODO
                }

                val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
                builder.setView(dialogView)

                val alertDialog = builder.show()
                alertDialog.getButton(Dialog.BUTTON_POSITIVE)
                    .setTextColor(ContextCompat.getColor(this, R.color.primary_color_500))
            }
            R.id.joinSwarmButton->{

//                val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_warn, null)
//                //AlertDialogBuilder
//                val mBuilder = AlertDialog.Builder(this)
//                    .setView(mDialogView)
////                    .setTitle("Login Form")
//                //show dialog
//                val  mAlertDialog = mBuilder.show()
//                //login button click of custom layout
//                mDialogView.tv_exit.setOnClickListener {
////                    //dismiss dialog
//                    mAlertDialog.dismiss()
//                }
////                //cancel button click of custom layout
//                mDialogView.tv_understand.setOnClickListener {
//                    mAlertDialog.dismiss()
//                    val intent = Intent(this, activity_warn::class.java)
//                    startActivity(intent)
//                    finish()
//                }

                val intent = Intent(this, activity_swarm_warning::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()

            }
        }
    }
}
