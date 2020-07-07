package Crypto.born.cryption.adapter

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.gabriel.swarmintelligence.R
import com.mikhaellopez.circularimageview.CircularImageView

internal class ImageListAdapter (private val context: Activity, private val avatar_array: Array<Int>, private val username: Array<String>, private val fname: Array<String>, private val lname: Array<String>, private val sent_invite_array: Array<String>)
    : ArrayAdapter<String>(context, R.layout.item_discover_people, username) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_discover_people, null, true)


        val avatar = rowView.findViewById(R.id.avatar) as CircularImageView
        val user_name = rowView.findViewById(R.id.user_name) as TextView
        val fName = rowView.findViewById(R.id.fName) as TextView
        val lName = rowView.findViewById(R.id.lName) as TextView
        val sent_invite = rowView.findViewById(R.id.sent_invite) as TextView

        avatar.setImageResource(avatar_array[position])
        user_name.text = username[position]
        fName.text = fname[position]
        lName.text = lname[position]
        sent_invite.text = sent_invite_array[position]
        return rowView
    }
}