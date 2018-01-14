package com.codingblocks.githubapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by harshit on 14/01/18.
 */
class GithubAdapter(private val users: ArrayList<Item>, val context: Context) : RecyclerView.Adapter<GithubAdapter.MyHolder>() {

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val currentUser = users[position]
        holder.itemView.tvName.text = currentUser.login
        holder.itemView.tvScore.text = currentUser.score.toString()
        holder.itemView.tvUrl.text = currentUser.url
    }

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder =
            MyHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_user, parent, false))

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}