package com.biti.whatsapplayout

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

class StatusAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.status_item,
                parent,
                false)
        return StatusHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(context).load(R.drawable.g).into((holder as StatusHolder).statusImage)
        holder.userName.text = "Gourav"
        holder.statusTime.text = "9 minute ago"
    }

    override fun getItemCount(): Int {
        return 10
    }

    internal inner class StatusHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var statusImage: ImageView = itemView.findViewById(R.id.status_image)
        var userName: TextView = itemView.findViewById(R.id.user_name)
        var statusTime: TextView = itemView.findViewById(R.id.status_time)

    }
}
