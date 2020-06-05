package com.impact.grandsupportapp.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.Lesson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LessonListRvAdapter(var context: Context, var items: MutableList<Lesson>, var navController: NavController): RecyclerView.Adapter<LessonListRvAdapter.ViewHolder>() {
    private var listener: OnСlickListener? = null
    private var lessonList: MutableList<Lesson>? = null


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
            getData(position)

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

     fun getData(position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
          val data = dataProcess(items)
            delay(500)
            lessonList = data
            val lesson = dataToLesson(position)
            delay(500)
            var bundle = Bundle()
            bundle.putParcelable("lesson", lesson)
            delay(100)
            Log.d("LessonComplete1", lesson?.name.toString())
            navController.navigate(R.id.action_lessonListFragment_to_lessonPlaceFragment, bundle)
        }
    }

    suspend fun dataProcess(items: MutableList<Lesson>): MutableList<Lesson> {
        return items
    }
    suspend fun dataToLesson(position: Int): Lesson? {
        var lesson = lessonList?.get(position)
        return lesson
    }
}

