package com.gabriel.swarmintelligence.activity_team

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.gabriel.swarmintelligence.adapter.AchListAdapter
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_achievements.*
import kotlinx.android.synthetic.main.fragment_achievements.fab
import kotlinx.android.synthetic.main.fragment_achievements.teamButton
import kotlinx.android.synthetic.main.layout_header.view.*

class activity_team_achievements : AppCompatActivity() , View.OnClickListener{
    val ach_mark = arrayOf<Int>(R.drawable.ic_checked, R.drawable.ic_unchecked, R.drawable.ic_checked, R.drawable.ic_unchecked, R.drawable.ic_checked, R.drawable.ic_unchecked, R.drawable.ic_checked)
    val username = arrayOf<String>(
        "First ach", "First ach", "First ach", "First ach", "First ach", "First ach", "First ach"
    )

    val points = arrayOf<String>(
        "+200", "+185", "+180", "+185", "+180", "+185", "+180"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_achievements)

        header_title.titleText.text = getString(R.string.team_achievements)
        header_title.setOnClickListener(this)

        val myListAdapter = AchListAdapter(this,ach_mark,username,points)
        lv_ach_point.adapter = myListAdapter
        lv_ach_point.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }

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
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when(v?.id) {
            R.id.header_title->{
                val intent = Intent(this, activity_team_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}