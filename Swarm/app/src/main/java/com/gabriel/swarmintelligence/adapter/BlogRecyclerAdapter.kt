package com.gabriel.swarmintelligence.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gabriel.swarmintelligence.Model.BlogPost
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.minterface.RVOnItemClickListener
import kotlinx.android.synthetic.main.item_fav_search_result.view.*


class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private var items: List<BlogPost> = ArrayList()

    private var myListener: RVOnItemClickListener? = null

    fun BlogRecyclerAdapter(_myListener: RVOnItemClickListener){
        myListener = _myListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_fav_search_result, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
        holder.itemView.setOnClickListener { v ->
            myListener?.RVonitemlistener(v, position)
            Log.e("Click", position.toString())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPost>){
        items = blogList
    }

    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val item_fav_avatar = itemView.item_fav_avatar
        val item_fav_user_name = itemView.item_fav_user_name

        fun bind(blogPost: BlogPost){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(item_fav_avatar)
            item_fav_user_name.setText(blogPost.username)

        }
    }
}
