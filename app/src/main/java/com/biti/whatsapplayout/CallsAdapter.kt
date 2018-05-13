package com.biti.whatsapplayout

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

class CallsAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.call_item,
                parent, false)

        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ChatHolder).callerName.text = context.getString(R.string.person_name)
        holder.callTime.text = context.getString(R.string.call_time)
        Glide.with(context).load(R.drawable.g).into(holder.callerImage)
    }

    override fun getItemCount(): Int {
        return 20
    }

    private inner class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var callerImage: ImageView = itemView.findViewById(R.id.caller_image)
        internal var callerName: TextView = itemView.findViewById(R.id.caller_name)
        internal var callTime: TextView = itemView.findViewById(R.id.call_time)

        override fun onClick(v: View) {

        }
    }

}
