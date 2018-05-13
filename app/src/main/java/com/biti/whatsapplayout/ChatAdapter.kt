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

class ChatAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item,
                parent, false)

        return ChatHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ChatHolder).userName.text = "Gourav"
        holder.unreadCnt.text = "7"
        holder.latestTime.text = "Yesterday"
        holder.latestMessage.text = "Dummy Text!"
        Glide.with(context).load(R.drawable.g).into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return 20
    }

    private inner class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var userImage: ImageView = itemView.findViewById(R.id.user_image)
        internal var userName: TextView = itemView.findViewById(R.id.my_status)
        internal var latestMessage: TextView = itemView.findViewById(R.id.latest_message)
        internal var latestTime: TextView = itemView.findViewById(R.id.latest_time)
        internal var unreadCnt: TextView = itemView.findViewById(R.id.unread_messages)

        override fun onClick(v: View) {

        }
    }

}
