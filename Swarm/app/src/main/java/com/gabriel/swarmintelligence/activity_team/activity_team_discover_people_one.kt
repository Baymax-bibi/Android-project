package com.gabriel.swarmintelligence.activity_team

import Crypto.born.cryption.adapter.ImageListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_discover_people_one.*
import kotlinx.android.synthetic.main.fragment_discover_people_one.fab
import kotlinx.android.synthetic.main.fragment_discover_people_one.teamButton
import kotlinx.android.synthetic.main.layout_header.view.*

class activity_team_discover_people_one  : AppCompatActivity() , View.OnClickListener{


    private val username: Array<String>
        get() = arrayOf("username 1", "username 2", "username 3", "username 4", "username 5", "username 6", "username 7", "username 8", "username 9", "username 10", "Item 11", "Item 12", "Item 13")
    private val fname: Array<String>
        get() = arrayOf("fname 1", "fname 2", "fname 3", "fname 4", "fname 5", "fname 6", "fname 7", "fname 8", "fname 9", "fname 10", "fname 11", "fname 12", "fname 13")
    private val lname: Array<String>
        get() = arrayOf("lname 1", "lname 2", "lname 3", "lname 4", "lname 5", "lname 6", "lname 7", "lname 8", "lname 9", "lname 10", "lname 11", "lname 12", "lname 13")

    private val sent_invite_m: Array<String>
        get() = arrayOf("SENT", "INVITE", "SENT", "SENT", "SENT", "SENT", "SENT", "SENT", "SENT", "SENT", "SENT", "SENT", "SENT")
    val imageId = arrayOf<Int>(
        R.drawable.download,R.drawable.download,R.drawable.download,
        R.drawable.download,R.drawable.download,R.drawable.download,
        R.drawable.download,R.drawable.download,R.drawable.download,
        R.drawable.download,R.drawable.download,R.drawable.download,
        R.drawable.download
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_discover_people_one)

        header_title_discover.titleText.text = getString(R.string.team_discover)
        header_title_discover.setOnClickListener(this)
        val adapter = ImageListAdapter(this, imageId,username, fname, lname, sent_invite_m)
        lv_discover.adapter = adapter

        lv_discover.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)


            val itemValue = lv_discover.getItemAtPosition(position) as String
            val item_invite = sent_invite_m[position]

            Toast.makeText(this, "Click on item at $itemAtPos its item invite  $item_invite", Toast.LENGTH_LONG).show()
            sent_invite_m[position] = getString(R.string.SENT)
            adapter.notifyDataSetChanged()
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
//        TODO("Not yet implemented")
        when(v?.id) {

            R.id.header_title_discover->{
                val intent = Intent(this, activity_team_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}