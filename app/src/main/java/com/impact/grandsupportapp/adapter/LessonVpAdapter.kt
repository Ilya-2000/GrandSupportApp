package com.impact.grandsupportapp.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.Lesson
import com.squareup.picasso.Picasso

class LessonVpAdapter(val item: Lesson?) : RecyclerView.Adapter<PagerVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        var itemView =
            PagerVH(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.lesson_item, parent, false))

        return itemView
    }
    



    override fun getItemCount(): Int = item?.steps!!

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        holder.bind(item, position)
    }
}

class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val textLesson = itemView.findViewById<TextView>(R.id.lesson_text_item)
    private val titleLesson = itemView.findViewById<TextView>(R.id.lesson_title_item)
    private val imageLesson = itemView.findViewById<ImageView>(R.id.lesson_img_item)
    fun bind(item: Lesson?, position: Int) {
        Picasso.get()
            .load(item?.imageList?.get(position))
            .into(imageLesson)
        textLesson.text = item?.textList?.get(position)
        titleLesson.text = item?.name
    }
}