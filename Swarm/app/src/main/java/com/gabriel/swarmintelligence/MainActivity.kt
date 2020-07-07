package com.gabriel.swarmintelligence

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.gabriel.swarmintelligence.Model.AuthModel
import com.gabriel.swarmintelligence.activity_lead.activity_lead_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import com.google.gson.Gson
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import id.voela.actrans.AcTrans
import io.vrinda.kotlinpermissions.DeviceInfo
import kotlinx.android.synthetic.main.activity_main.*
import java.io.UnsupportedEncodingException
import java.util.*


class MainActivity : AppCompatActivity(){

    var deviceID : String = ""
    var deviceModel : String = ""
//    private var imeiText: TextView? = null

    var perms: Array<String> =
        arrayOf(Manifest.permission.READ_PHONE_STATE)
    companion object {

        private val REQUEST_READ_PHONE_STATE = 1123
        private val REQUEST_READ_PHONE_STATE_CLICK = 1124
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "ed3653fc-6226-458a-a000-7d00e47981b1",
            Analytics::class.java, Crashes::class.java
        )

        getDeviceData()

        fab.setOnClickListener{v->

            startActivity(Intent(this, activity_lead_main::class.java))
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

    private fun getDeviceData() {
        ActivityCompat.requestPermissions(this, perms, REQUEST_READ_PHONE_STATE_CLICK)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_READ_PHONE_STATE_CLICK -> {
                var phoneStateAccepted: Boolean = grantResults[0] == PackageManager.PERMISSION_GRANTED
                if (phoneStateAccepted) {
                    showData()
                } else {
                    Toast.makeText(this, "Permission Denied.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("HardwareIds")
    private fun showData() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val mTelephonyMgr: TelephonyManager =
            getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager


        try {
            mTelephonyMgr.deviceId?.let {
                deviceID = "${it}"
            }

            deviceModel = DeviceInfo.getModel()
            Log.e("IMEI&Model", deviceID + " || " + deviceModel)

//            if (m_getBoolean(getString(R.string.Is_First))){
//
//            }else{
                loadingAuth()
//            }

        } catch (e: Exception) {
        }
    }

    private fun loadingAuth() {
        val queue = Volley.newRequestQueue(this@MainActivity)
        val requestBody = "{\"CreateAccount\": true,\n" +
                "\"AndroidDeviceId\": \""+deviceID+"\",\n" +
                "\"DeviceModel\":\""+deviceModel+"\",\n" +
                "\"TitleId\": \"B95FB\"\n" +
                "}"
        val url: String = "https://b95fb.playfabapi.com/Client/LoginWithAndroidDeviceID"

        val sr: StringRequest = object : StringRequest(
            Method.POST,
            url,
            Response.Listener { response ->
                var gson = Gson()
//                var jsonString = gson.toJson(AuthModel(1,"Test"))
                val authModel = gson.fromJson<AuthModel>(response, AuthModel::class.java)
                val authData = authModel.data
                val authData_sessionTicket = authData.SessionTicket
                val authData_playFabId = authData.PlayFabId //getting
                val authData_NewlyCreated = authData.NewlyCreated

                val authData_EntityToken = authData.EntityToken
                val authData_EntityToken_EntityToken = authData_EntityToken.EntityToken
                val authData_EntityToken_Entity = authData_EntityToken.Entity
                val authData_EntityToken_Entity_Id = authData_EntityToken_Entity.Id
                val authData_EntityToken_Entity_Type = authData_EntityToken_Entity.Type

                m_insertString(getString(R.string.PlayFabId), authData_playFabId)
                m_insertBoolean(getString(R.string.NewlyCreated), authData_NewlyCreated)
                m_insertString(getString(R.string.EntityToken), authData_EntityToken_EntityToken)
                m_insertString(getString(R.string.EntityId), authData_EntityToken_Entity_Id)
                m_insertString(getString(R.string.EntityType), authData_EntityToken_Entity_Type)
                m_insertBoolean(getString(R.string.Is_First), true)

            },
            Response.ErrorListener { error ->
                Log.e("Service category", error.toString())
            }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            @Throws(AuthFailureError::class)
            override fun getBody(): ByteArray? {
                return try {
                    requestBody?.toByteArray(charset("utf-8"))
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

    @Synchronized
    fun m_insertString(key: String?, value: String?) {
        val mSharedPreferences =
            getSharedPreferences(resources.getString(R.string.PREF_NAME), Context.MODE_PRIVATE)
        val mEditor = mSharedPreferences.edit()
        mEditor.putString(key, value)
        mEditor.apply()
    }

    @Synchronized
    fun m_insertBoolean(key: String?, value: Boolean) {
        val mSharedPreferences: SharedPreferences =
            getSharedPreferences(resources.getString(R.string.PREF_NAME), Context.MODE_PRIVATE)
        val mEditor = mSharedPreferences.edit()
        mEditor.putBoolean(key, value)
        mEditor.apply()
    }

    @Synchronized
    fun m_getBoolean(key: String?): Boolean {
        val mSharedPreferences: SharedPreferences =
            getSharedPreferences(resources.getString(R.string.PREF_NAME), Context.MODE_PRIVATE)
        return mSharedPreferences.getBoolean(key, false)
    }
}

