package com.impact.grandsupportapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.Lesson

class LessonListRvAdapter(var context: Context, var items: List<Lesson>, var navController: NavController): RecyclerView.Adapter<LessonListRvAdapter.ViewHolder>() {
    private var listener: OnСlickListener? = null
    fun setListener(listener: OnСlickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LessonListRvAdapter.ViewHolder {
        val itemView = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.lesson_card_item,
                parent,
                false
            )
        )
        return itemView
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: LessonListRvAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "click ${position.toString()}", Toast.LENGTH_LONG).show()
        }
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName = itemView.findViewById<TextView>(R.id.name_lesson_item)
        private val itemSteps = itemView.findViewById<TextView>(R.id.steps_lesson_item)

        fun  bind(item: Lesson) {
            itemName.text = item.name
            itemSteps.text = item.steps.toString()
        }
    }

    public interface OnСlickListener {
        fun onClick(position: Int)

    }
}

