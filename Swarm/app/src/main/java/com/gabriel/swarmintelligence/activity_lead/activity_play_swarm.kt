package com.gabriel.swarmintelligence.activity_lead

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.dialog_video.view.*
import kotlinx.android.synthetic.main.fragment_play_swarm.*
import kotlinx.android.synthetic.main.fragment_play_swarm.fab
import kotlinx.android.synthetic.main.fragment_play_swarm.teamButton
import kotlinx.android.synthetic.main.fragment_warn.*


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

        val Countries = arrayOf(
            "Vatican", "Brazil",
            "Switzerland", "Angola", "Haiti", "Puerto Rico", "Germany", "Mexico",
            "France", "Ireland", "India", "Australia", "Zimbabwe", "South Africa",
            "Canada", "Thailand", "Japan", "Chile", "Botswana", "El Salvador", "Cuba",
            "Vietnam", "Mongolia", "Morocco", "Italy", "Portugal", "Ukrain"
        )

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                this,
                android.R.layout.select_dialog_item,
                Countries
            )
        //Getting the instance of AutoCompleteTextView
        //Getting the instance of AutoCompleteTextView
        val actv =
            findViewById<View>(R.id.auto_tv_one) as AutoCompleteTextView

        val et_thory =
            findViewById<View>(R.id.et_thory) as AutoCompleteTextView
//        actv.threshold = 1 //will start working from first character

        actv.setAdapter(adapter) //setting the adapter data into the AutoCompleteTextView
        et_thory.setAdapter(adapter) //setting the adapter data into the AutoCompleteTextView
        actv.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>,
                arg1: View?,
                position: Int,
                arg3: Long
            ) {
                hideKeyboard()
            }
        })

        et_thory.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                hideKeyboard()
            }
        })

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


    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id) {
            R.id.btn_continue -> {
                if (auto_tv_one.length() > 0 && et_thory.length() > 0){
                    val intent = Intent(this, activity_counter::class.java)
                    startActivity(intent)
                    AcTrans.Builder(this).performNoAnimation()
                    finish()
                }

                else{
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
