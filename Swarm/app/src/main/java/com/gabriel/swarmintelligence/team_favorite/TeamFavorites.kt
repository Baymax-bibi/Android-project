package com.gabriel.swarmintelligence.team_favorite

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.swarmintelligence.Model.BlogPost
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.Utils.DataSource
import com.gabriel.swarmintelligence.Utils.TopSpacingItemDecoration
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.adapter.BlogRecyclerAdapter
import com.gabriel.swarmintelligence.minterface.RVOnItemClickListener
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.activity_favorites.*
import kotlinx.android.synthetic.main.layout_header.view.*

class TeamFavorites :AppCompatActivity(), View.OnClickListener {

    private lateinit var blogAdapter: BlogRecyclerAdapter
    var rvOnItemClickListener: RVOnItemClickListener? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_favorites)

        header_title.titleText.text = getString(R.string.FAVORITES)
        header_title.setOnClickListener(this)
        img_plus.setOnClickListener(this)

//        recyclerview
        initRecyclerView()
        addDataSet()

        rvOnItemClickListener = object : RVOnItemClickListener {
            override fun RVonitemlistener(v: View, position: Int) {
                Log.e("TAB", position.toString())
            }
        }

        blogAdapter = BlogRecyclerAdapter()

        fab.setOnClickListener{v->
            val intent = Intent(this, activity_lead_main::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }
        teamButton.setOnClickListener{v->
            val intent = Intent(this, activity_team_main::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }
    }

    private fun addDataSet() {
        val data : ArrayList<BlogPost> = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    @SuppressLint("WrongConstant")
    private fun initRecyclerView() {
        rv_fav.apply {
            layoutManager = LinearLayoutManager(this@TeamFavorites, LinearLayout.VERTICAL, false)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
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
                startActivity(Intent(this, TeamFavSearch::class.java))
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}