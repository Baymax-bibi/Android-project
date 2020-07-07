package com.gabriel.swarmintelligence.activity_team

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.gabriel.swarmintelligence.Model.CreateGroupModel
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.fragment_create_team_interrupt.*
import kotlinx.android.synthetic.main.layout_header.view.*
import java.io.UnsupportedEncodingException
import java.util.*


class activity_team_create_team_interrupt  : AppCompatActivity() , View.OnClickListener{
    var et_teamname : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_create_team_interrupt)

        header_title.titleText.text = getString(R.string.CREATETEAM)

        header_title.setOnClickListener(this)
        btn_create_team.setOnClickListener(this)

        et_teamname = findViewById<EditText>(R.id.et_teamname)

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

//        Log.e("teamname", et_teamname.toString())
//        Log.e("header", m_getString(getString(R.string.EntityToken)).toString())
    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.btn_create_team->{
//                val intent = Intent(this, activity_team_create_team_interrupt_sync::class.java)
//                startActivity(intent)
//                AcTrans.Builder(this).performNoAnimation()
//                finish()
                m_CreateTeam()
            }
            R.id.header_title->{
                val intent = Intent(this, activity_team_main::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }

    private fun m_CreateTeam() {
        Log.e("Teamname", et_teamname?.text.toString())
        Log.e("Token", m_getString(getString(R.string.EntityToken)).toString())
        val queue = Volley.newRequestQueue(this@activity_team_create_team_interrupt)
        val requestBody = "{\n" +
                "\"GroupName\": \""+ et_teamname?.text.toString() +"\"\n" +
                "}"

        val url: String = "https://b95fb.playfabapi.com/Group/CreateGroup"

        val sr: StringRequest = object : StringRequest(
            Method.POST,
            url,
            Response.Listener { response ->
                var gson = Gson()
//                var jsonString = gson.toJson(AuthModel(1,"Test"))
//                val authModel = gson.fromJson<AuthModel>(response, AuthModel::class.java)
//                val authData = authModel.data
//                val authData_sessionTicket = authData.SessionTicket
//                val authData_playFabId = authData.PlayFabId //getting
//                val authData_NewlyCreated = authData.NewlyCreated
//
//                val authData_EntityToken = authData.EntityToken
//                val authData_EntityToken_EntityToken = authData_EntityToken.EntityToken
//                val authData_EntityToken_Entity = authData_EntityToken.Entity
//                val authData_EntityToken_Entity_Id = authData_EntityToken_Entity.Id
//                val authData_EntityToken_Entity_Type = authData_EntityToken_Entity.Type
//
//                m_insertString(getString(R.string.PlayFabId), authData_playFabId)
//                m_insertBoolean(getString(R.string.NewlyCreated), authData_NewlyCreated)
//                m_insertString(getString(R.string.EntityToken), authData_EntityToken_EntityToken)
//                m_insertString(getString(R.string.EntityId), authData_EntityToken_Entity_Id)
//                m_insertString(getString(R.string.EntityType), authData_EntityToken_Entity_Type)
//                m_insertBoolean(getString(R.string.Is_First), true)

                var createModel = gson.fromJson<CreateGroupModel>(response, CreateGroupModel::class.java)
                val createdCode = createModel.code

                val createdData = createModel.data
                val createdData_Group = createdData.Group
                val createdData_Group_Id = createdData_Group.Id
                val createdData_Group_Type = createdData_Group.Type

                Log.e("TEAM", createdData_Group_Id + " | "+createdData_Group_Type )

            },
            Response.ErrorListener { error ->
                Log.e("Service category", error.toString())
                Toast.makeText(this@activity_team_create_team_interrupt, "This group name is already in use.", Toast.LENGTH_SHORT).show();
            }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            @Throws(AuthFailureError::class)
            override fun getBody(): ByteArray? {
                return try {
                    requestBody.toByteArray(charset("utf-8"))
                } catch (uee: UnsupportedEncodingException) {
                    VolleyLog.wtf(
                        "Unsupported Encoding while trying to get the bytes of %s using %s",
                        requestBody,
                        "utf-8"
                    )
                    return null
                }
            }
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> =
                    HashMap()
                params["Content-Type"] = "application/json"
                params["X-EntityToken"] = m_getString(getString(R.string.EntityToken)).toString()
                return params
            }
        }
        queue.add(sr)
    }
    fun m_getString(key: String?): String? {
        val mSharedPreferences =
            getSharedPreferences(resources.getString(R.string.PREF_NAME), Context.MODE_PRIVATE)
        return mSharedPreferences.getString(key, "")
    }
}