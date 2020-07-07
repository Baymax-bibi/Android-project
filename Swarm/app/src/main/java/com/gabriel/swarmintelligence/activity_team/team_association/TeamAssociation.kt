package com.gabriel.swarmintelligence.activity_team.team_association

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.swarmintelligence.Model.AssModel
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.Utils.DataAss
import com.gabriel.swarmintelligence.Utils.TopSpacingItemDecoration
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.gabriel.swarmintelligence.adapter.TeamAssAdapter
import com.gabriel.swarmintelligence.minterface.RVOnItemClickListener
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_accociation.*
import kotlinx.android.synthetic.main.activity_favorites.fab
import kotlinx.android.synthetic.main.activity_favorites.header_title
import kotlinx.android.synthetic.main.activity_favorites.img_plus
import kotlinx.android.synthetic.main.activity_favorites.teamButton
import kotlinx.android.synthetic.main.layout_header.view.*

class TeamAssociation  : AppCompatActivity(), View.OnClickListener {

    private lateinit var teamAssAdapter: TeamAssAdapter
    var rvOnItemClickListener: RVOnItemClickListener? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_accociation)

        header_title.titleText.text = getString(R.string.ASSOCIATION)
        header_title.setOnClickListener(this)
        img_plus.setOnClickListener(this)

        rvOnItemClickListener = object : RVOnItemClickListener {
            override fun RVonitemlistener(v: View, position: Int) {
                Log.e("Clicked_m", position.toString())
                teamAssAdapter.remove(position)
            }
        }

        initRecyclerView()
        addDataSet()


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

    private fun addDataSet() {
        val data : ArrayList<AssModel> = DataAss.createDataSet()
        teamAssAdapter.submitList(data)
    }

    @SuppressLint("WrongConstant")
    private fun initRecyclerView() {
        rv_ass.apply {
            layoutManager = LinearLayoutManager(this@TeamAssociation, LinearLayout.VERTICAL, false)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            teamAssAdapter = TeamAssAdapter(rvOnItemClickListener as RVOnItemClickListener)
            adapter = teamAssAdapter
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.header_title->{
                val intent = Intent(this, activity_team_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
            R.id.img_plus->{
                startActivity(Intent(this, TeamAssAdd::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}