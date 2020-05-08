package com.impact.grandsupportapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.impact.grandsupportapp.R

class LessonVpAdapter : RecyclerView.Adapter<PagerVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.lesson_item, parent, false))


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        TODO("Not yet implemented")
    }

}

class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView) {

}