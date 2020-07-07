package com.gabriel.swarmintelligence.activity_lead

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_counter.*
import kotlinx.android.synthetic.main.fragment_counter.fab
import kotlinx.android.synthetic.main.fragment_counter.teamButton

class activity_counter : AppCompatActivity(){

    var count_int: Int = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_counter)
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

        val spannableString = SpannableString(getString(R.string.counter_content))
        spannableString.setSpan(RelativeSizeSpan(1.5f), 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(StyleSpan(Typeface.BOLD), 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_counter_content.setText(spannableString)

        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tv_counter.setText(count_int.toString())
                --count_int
            }

            override fun onFinish() {
//                val Fragment_SwarmReview = fragment_SwarmReview();
//                childFragmentManager.beginTransaction().replace(R.id.container,Fragment_SwarmReview).commit()
//                val intent = Intent(this, activity_swarm_review::class.java)
//                startActivity(intent)
//                finish()
                goto_swarmReview()
            }
        }
        timer.start()
    }

    fun goto_swarmReview(){
        val intent = Intent(this, activity_swarm_review::class.java)
        startActivity(intent)
        AcTrans.Builder(this).performNoAnimation()
        finish()
    }
}

