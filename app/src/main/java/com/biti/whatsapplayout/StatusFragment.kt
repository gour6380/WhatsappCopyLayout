package com.biti.whatsapplayout

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StatusFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.status_fragment_layout, null, false)


        val decoration = SeparatorDecoration(
                context!!,
                Color.parseColor("#EAEAEA"),
                0.5f)
        val recyclerView: RecyclerView = view.findViewById(R.id.status_rv)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = StatusAdapter(context!!)
        recyclerView.addItemDecoration(decoration)

        return view
    }
}
